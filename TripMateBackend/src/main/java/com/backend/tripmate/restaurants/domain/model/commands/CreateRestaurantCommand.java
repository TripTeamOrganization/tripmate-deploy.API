package com.backend.tripmate.restaurants.domain.model.commands;

public record CreateRestaurantCommand(String name, String imagePath, String locationCost, String mustTry) {
}
