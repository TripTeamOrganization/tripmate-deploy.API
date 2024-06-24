package com.backend.tripmate.restaurants.interfaces.rest.transform;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.interfaces.rest.resources.CreateRestaurantResource;

public class CreateRestaurantCommandFromResourceAssembler {
    public static CreateRestaurantCommand toCommandFromResource(CreateRestaurantResource resource) {
        return new CreateRestaurantCommand(
            resource.name(),
            resource.imagePath(),
            resource.locationCost(),
            resource.mustTry()
        );
    }
}
