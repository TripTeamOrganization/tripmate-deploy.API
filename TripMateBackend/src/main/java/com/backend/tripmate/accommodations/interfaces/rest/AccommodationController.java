package com.backend.tripmate.accommodations.interfaces.rest;

import com.backend.tripmate.accommodations.application.internal.commandservices.AccommodationCommandServiceImpl;
import com.backend.tripmate.accommodations.domain.model.queries.GetAccommodationByIdQuery;
import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.DeleteAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.UpdateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.domain.model.queries.GetAllAccommodationsQuery;
import com.backend.tripmate.accommodations.domain.services.AccommodationQueryService;
import com.backend.tripmate.accommodations.interfaces.rest.resources.AccommodationResource;
import com.backend.tripmate.accommodations.interfaces.rest.resources.CreateAccomodationsResource;
import com.backend.tripmate.accommodations.interfaces.rest.resources.UpdateAccomodatonsResource;
import com.backend.tripmate.accommodations.interfaces.rest.transform.AccommodationResourceFromEntityAssembler;
import com.backend.tripmate.accommodations.interfaces.rest.transform.CreateAccomodationsCommandFromResourceAssembler;
import com.backend.tripmate.accommodations.interfaces.rest.transform.UpdateAccomodationsCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller for managing accommodations.
 *
 * @author Paolo Del Carmen Martinez Villanueva
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/accommodations", produces = APPLICATION_JSON_VALUE)
public class AccommodationController {

    private final AccommodationQueryService accommodationQueryService;
    private final AccommodationCommandServiceImpl accommodationCommandService;

    /**
     * Constructor for AccommodationController.
     *
     * @param accommodationQueryService the accommodation query service
     * @param accommodationCommandService the accommodation command service
     */
    public AccommodationController(AccommodationQueryService accommodationQueryService, AccommodationCommandServiceImpl accommodationCommandService) {
        this.accommodationQueryService = accommodationQueryService;
        this.accommodationCommandService = accommodationCommandService;
    }

    /**
     * Get all accommodations.
     *
     * @return a list of all accommodations
     */
    @GetMapping
    public ResponseEntity<List<AccommodationResource>> getAllAccommodations() {
        var getAllAccommodationsQuery = new GetAllAccommodationsQuery();
        var accommodations = accommodationQueryService.handle(getAllAccommodationsQuery);
        var accommodationResources = accommodations.stream()
                .map(AccommodationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(accommodationResources);
    }

    /**
     * Get an accommodation by its id.
     *
     * @param id the id of the accommodation
     * @return the accommodation with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable Long id) {
        GetAccommodationByIdQuery query = new GetAccommodationByIdQuery(id);
        var accommodation = accommodationCommandService.getAccommodationById(query);
        if (accommodation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accommodation.get());
    }

    /**
     * Create a new accommodation.
     *
     * @param resource the accommodation resource
     * @return a response entity with the status of the operation
     */
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationResource> createAccommodation(@RequestBody CreateAccomodationsResource resource) {
        try {
            CreateAccommodationsCommand command = CreateAccomodationsCommandFromResourceAssembler.toCommandFromResource(resource);
            var accommodation = accommodationCommandService.handle(command);
            var accommodationResource = AccommodationResourceFromEntityAssembler.toResourceFromEntity(accommodation.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(accommodationResource);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update an accommodation.
     *
     * @param id the id of the accommodation
     * @param resource the accommodation resource
     * @return a response entity with the status of the operation
     */
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationResource> updateAccommodation(@PathVariable Long id, @RequestBody UpdateAccomodatonsResource resource) {
        try {
            UpdateAccommodationsCommand command = UpdateAccomodationsCommandFromResourceAssembler.toCommandFromResource(id, resource);
            accommodationCommandService.handle(command);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Delete an accommodation.
     *
     * @param id the id of the accommodation
     * @return a response entity with the status of the operation
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        try {
            var command = new DeleteAccommodationsCommand(id);
            accommodationCommandService.handle(command);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}