package com.backend.tripmate.activities.interfaces.rest.transform;

import com.backend.tripmate.activities.domain.commands.DeleteActivityCommand;
import com.backend.tripmate.activities.interfaces.rest.resources.DeleteActivityResource;

public class DeleteActivityCommandFromResourceAssembler {
    public static DeleteActivityCommand toCommandFromResource(DeleteActivityResource resource) {
        return new DeleteActivityCommand(resource.id());
    }
}
