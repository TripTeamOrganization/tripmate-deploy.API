package com.backend.tripmate.accommodations.interfaces.rest.transform;

import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.interfaces.rest.resources.AccommodationResource;

public class AccommodationResourceFromEntityAssembler {

    public static AccommodationResource toResourceFromEntity(Accommodation accommodation) {
        return new AccommodationResource(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getImagePath(),
                accommodation.getDescription(),
                accommodation.getUbicacion(),
                accommodation.getPrice()
        );
    }
}
