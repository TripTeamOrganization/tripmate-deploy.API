package com.backend.tripmate.activities.interfaces.rest.transform;

import com.backend.tripmate.activities.domain.commands.UpdateActivityCommand;
import com.backend.tripmate.activities.interfaces.rest.resources.UpdateActivityResource;

public class UpdateActivityCommandFromResourceAssembler {
    public static UpdateActivityCommand toCommandFromResource(Long id, UpdateActivityResource resource) {
        return new UpdateActivityCommand(id, resource.name(), resource.imagePath(), resource.description(), resource.location(), resource.price());
    }
}
