package com.backend.tripmate.accommodations.interfaces.rest.transform;

import com.backend.tripmate.accommodations.domain.model.commands.DeleteAccommodationsCommand;
import com.backend.tripmate.accommodations.interfaces.rest.resources.DeleteAccomodationsResource;

public class DeleteAccomodationsCommandFromResourceAssembler {
    public static DeleteAccommodationsCommand toCommandFromResource(DeleteAccomodationsResource resource) {
        return new DeleteAccommodationsCommand(resource.id());
    }
}