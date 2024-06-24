package com.backend.tripmate.restaurants.interfaces.rest.resources;

public record CreateRestaurantResource(String name, String imagePath, String locationCost, String mustTry) {
}
