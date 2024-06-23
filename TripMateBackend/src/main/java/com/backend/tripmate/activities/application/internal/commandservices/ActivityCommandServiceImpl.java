package com.backend.tripmate.activities.application.internal.commandservices;

import com.backend.tripmate.activities.domain.commands.CreateActivityCommand;
import com.backend.tripmate.activities.domain.commands.DeleteActivityCommand;
import com.backend.tripmate.activities.domain.commands.UpdateActivityCommand;
import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.domain.services.ActivityCommandService;
import com.backend.tripmate.activities.infrastructure.persistence.jpa.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityCommandServiceImpl implements ActivityCommandService {
    private final ActivityRepository activityRepository;

    public ActivityCommandServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Optional<Activity> handle(CreateActivityCommand command) {
        if(activityRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Activity with same title already exists");
        }
        var activity = new Activity(command);
        try {
            activityRepository.save(activity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving activity: " + e.getMessage());
        }
        return Optional.of(activity);
    }

    @Override
    public Optional<Activity> handle(UpdateActivityCommand command) {
        validateUpdateCommand(command);
        var result = activityRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Activity does not exist");
        }
        var activityToUpdate = result.get();
        try {
            var updatedActivity = activityRepository.save(activityToUpdate.updateInformation(command.name(), command.imagePath(), command.description(), command.location(), command.price()));
            return Optional.of(updatedActivity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating activity: " + e.getMessage());
        }
    }

    private void validateUpdateCommand(UpdateActivityCommand command) {
        if (command.id() == null) {
            throw new IllegalArgumentException("Activity id is required");
        }
        if (command.name() == null) {
            throw new IllegalArgumentException("Activity name is required");
        }
        if (command.imagePath() == null) {
            throw new IllegalArgumentException("Activity image path is required");
        }
        if (command.description() == null) {
            throw new IllegalArgumentException("Activity description is required");
        }
        if (command.location() == null) {
            throw new IllegalArgumentException("Activity location is required");
        }
        if (command.price() == null) {
            throw new IllegalArgumentException("Activity price is required");
        }
    }

    @Override
    public void handle(DeleteActivityCommand command) {
        if (!activityRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Activity does not exist");
        }
        try {
            activityRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting activity: " + e.getMessage());
        }
    }

}
