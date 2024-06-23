package com.backend.tripmate.restaurants.domain.model.commands;

public record CreateRestaurantCommand(String name, String image, String locationCost, String mustTry) {
}
