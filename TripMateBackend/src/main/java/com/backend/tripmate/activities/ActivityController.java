package com.backend.tripmate.activities;

import com.backend.tripmate.activities.domain.commands.DeleteActivityCommand;
import com.backend.tripmate.activities.domain.model.queries.GetActivitiesByIdQuery;
import com.backend.tripmate.activities.domain.services.ActivityCommandService;
import com.backend.tripmate.activities.interfaces.rest.resources.ActivityResource;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;
import com.backend.tripmate.activities.domain.services.ActivityQueryService;

import com.backend.tripmate.activities.interfaces.rest.resources.CreateActivityResource;
import com.backend.tripmate.activities.interfaces.rest.resources.UpdateActivityResource;
import com.backend.tripmate.activities.interfaces.rest.transform.ActivityResourceFromEntityAssembler;
import com.backend.tripmate.activities.interfaces.rest.transform.CreateActivityCommandFromResourceAssembler;
import com.backend.tripmate.activities.interfaces.rest.transform.UpdateActivityCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller for managing activities.
 *
 * @author Bárbara Antonella Espinoza Delgado
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/activities", produces = APPLICATION_JSON_VALUE)
public class ActivityController {

    private final ActivityQueryService activityQueryService;
    private final ActivityCommandService activityCommandService;

    /**
     * Constructor for ActivityController.
     *
     * @param activityCommandService the activity command service
     * @param activityQueryService the activity query service
     */
    public ActivityController(ActivityCommandService activityCommandService, ActivityQueryService activityQueryService) {
        this.activityCommandService = activityCommandService;
        this.activityQueryService = activityQueryService;
    }

    /**
     * Create a new activity.
     *
     * @param resource the activity resource
     * @return a response entity with the status of the operation
     */
    @PostMapping
    public ResponseEntity<ActivityResource> createActivity(@RequestBody CreateActivityResource resource) {
        try {
            var createActivityCommand = CreateActivityCommandFromResourceAssembler.toCommandFromResource(resource);
            var activity = activityCommandService.handle(createActivityCommand);
            var activityResource = ActivityResourceFromEntityAssembler.toResourceFromEntity(activity.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(activityResource);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get all activities.
     *
     * @return a list of all activities
     */
    @GetMapping
    public ResponseEntity<List<ActivityResource>> getAllActivities() {
        var getAllActivitiesQuery = new GetAllActivitiesQuery();
        var activities = activityQueryService.handle(getAllActivitiesQuery);
        var activityResources = activities.stream().map(ActivityResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(activityResources);
    }

    /**
     * Get an activity by its id.
     *
     * @param activityId the id of the activity
     * @return the activity with the given id
     */
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResource> getActivityById(@PathVariable(name = "activityId") Long activityId) {
        var getActivitiesByIdQuery = new GetActivitiesByIdQuery(activityId);
        var activity = activityQueryService.handle(getActivitiesByIdQuery);
        if (activity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var activityResource = ActivityResourceFromEntityAssembler.toResourceFromEntity(activity.get());
        return ResponseEntity.ok(activityResource);
    }

    /**
     * Update an activity.
     *
     * @param activityId the id of the activity
     * @param resource the activity resource
     * @return a response entity with the status of the operation
     */
    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityResource> updateActivity(@PathVariable Long activityId, @RequestBody UpdateActivityResource resource) {
        var updateActivityCommand = UpdateActivityCommandFromResourceAssembler.toCommandFromResource(activityId, resource);
        var updatedActivity = activityCommandService.handle(updateActivityCommand);
        if (updatedActivity.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var activityResource = ActivityResourceFromEntityAssembler.toResourceFromEntity(updatedActivity.get());
        return ResponseEntity.ok(activityResource);
    }

    /**
     * Delete an activity.
     *
     * @param activityId the id of the activity
     * @return a response entity with the status of the operation
     */
    @DeleteMapping("/{activityId}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long activityId) {
        var deleteActivityCommand = new DeleteActivityCommand(activityId);
        activityCommandService.handle(deleteActivityCommand);
        return ResponseEntity.ok("Activity deleted successfully");
    }

}