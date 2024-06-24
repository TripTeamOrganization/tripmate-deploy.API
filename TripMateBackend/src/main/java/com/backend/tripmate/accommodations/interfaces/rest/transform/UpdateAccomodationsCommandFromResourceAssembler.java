package com.backend.tripmate.accommodations.interfaces.rest.transform;

import com.backend.tripmate.accommodations.domain.model.commands.UpdateAccommodationsCommand;
import com.backend.tripmate.accommodations.interfaces.rest.resources.UpdateAccomodatonsResource;

public class UpdateAccomodationsCommandFromResourceAssembler {
    public static UpdateAccommodationsCommand toCommandFromResource(Long id, UpdateAccomodatonsResource resource) {
        return new UpdateAccommodationsCommand(id, resource.name(), resource.imagePath(), resource.description(), resource.ubicacion(), resource.price());
    }
}