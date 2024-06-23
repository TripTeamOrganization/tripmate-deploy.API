package com.backend.tripmate.restaurants.interfaces.rest.transform;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.interfaces.rest.resources.RestaurantResource;

public class RestaurantResourceFromEntityAssembler {
    public static RestaurantResource toResourceFromEntity(Restaurant restaurant) {
        return new RestaurantResource(restaurant.getId(), restaurant.getName(), restaurant.getImage(), restaurant.getLocationCost(), restaurant.getMustTry());
    }
}
