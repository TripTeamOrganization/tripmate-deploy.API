package com.backend.tripmate.accommodations.interfaces.rest.transform;

import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
import com.backend.tripmate.accommodations.interfaces.rest.resources.CreateAccomodationsResource;

public class CreateAccomodationsCommandFromResourceAssembler {
    public static CreateAccommodationsCommand toCommandFromResource(CreateAccomodationsResource resource) {
        return new CreateAccommodationsCommand(resource.name(), resource.imagePath(), resource.description(), resource.ubicacion(), resource.price());
    }
}