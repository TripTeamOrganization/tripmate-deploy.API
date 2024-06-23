package com.backend.tripmate.restaurants.interfaces.rest.transform;

import com.backend.tripmate.restaurants.domain.model.commands.DeleteRestaurantCommand;

public class DeleteRestaurantCommandFromResourceAssembler {
    public static DeleteRestaurantCommand toCommandFromResource(Long id) {
        return new DeleteRestaurantCommand(
            id
        );
    }
}
