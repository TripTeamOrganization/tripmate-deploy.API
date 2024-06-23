package com.backend.tripmate.restaurants.interfaces.rest.resources;

public record CreateRestaurantResource(String name, String image, String locationCost, String mustTry) {
}
