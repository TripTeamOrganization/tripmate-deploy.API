package com.backend.tripmate.restaurants.domain.model.commands;

public record UpdateRestaurantCommand(Long id, String name, String image, String locationCost, String mustTry) {
}
