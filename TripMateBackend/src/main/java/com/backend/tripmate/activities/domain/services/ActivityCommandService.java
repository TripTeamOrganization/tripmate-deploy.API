package com.backend.tripmate.activities.domain.services;

import com.backend.tripmate.activities.domain.commands.CreateActivityCommand;
import com.backend.tripmate.activities.domain.commands.DeleteActivityCommand;
import com.backend.tripmate.activities.domain.commands.UpdateActivityCommand;
import com.backend.tripmate.activities.domain.model.entities.Activity;

import java.util.Optional;

public interface ActivityCommandService {
    Optional<Activity> handle(CreateActivityCommand command);
    Optional<Activity> handle(UpdateActivityCommand command);
    void handle(DeleteActivityCommand command);
}
