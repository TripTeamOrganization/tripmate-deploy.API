package com.backend.tripmate.restaurants.domain.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long aLong) {
        super("Restaurant with id " + aLong + " not found");
    }
}
