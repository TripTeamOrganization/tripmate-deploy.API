package com.backend.tripmate.restaurants.domain.services;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.DeleteRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;

import java.util.Optional;

public interface RestaurantCommandService {
    Optional<Restaurant> handle(CreateRestaurantCommand command);
    void handle(DeleteRestaurantCommand command);
    Optional<Restaurant> handle(UpdateRestaurantCommand command);
}
