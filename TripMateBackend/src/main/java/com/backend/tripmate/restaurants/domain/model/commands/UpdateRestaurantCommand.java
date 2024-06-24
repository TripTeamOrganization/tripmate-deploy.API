package com.backend.tripmate.restaurants.domain.model.commands;

public record UpdateRestaurantCommand(Long id, String name, String imagePath, String locationCost, String mustTry) {
}
