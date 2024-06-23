package com.backend.tripmate.restaurants.interfaces.rest.transform;

import com.backend.tripmate.restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.backend.tripmate.restaurants.interfaces.rest.resources.UpdateRestaurantResource;

public class UpdateRestaurantCommandFromResourceAssembler {
    public static UpdateRestaurantCommand toCommandFromResource(Long id, UpdateRestaurantResource resource) {
        return new UpdateRestaurantCommand(
            id,
            resource.name(),
            resource.image(),
            resource.locationCost(),
            resource.mustTry()
        );
    }
}
