package com.backend.tripmate.activities.interfaces.rest.transform;

import com.backend.tripmate.activities.domain.commands.CreateActivityCommand;
import com.backend.tripmate.activities.interfaces.rest.resources.CreateActivityResource;

public class CreateActivityCommandFromResourceAssembler {
    public static CreateActivityCommand toCommandFromResource(CreateActivityResource resource) {
        return new CreateActivityCommand(resource.name(), resource.imagePath(), resource.description(), resource.location(), resource.price());
    }
}
