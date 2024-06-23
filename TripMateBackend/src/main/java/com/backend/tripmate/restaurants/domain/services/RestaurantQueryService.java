package com.backend.tripmate.restaurants.domain.services;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.backend.tripmate.restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.backend.tripmate.restaurants.domain.model.queries.GetRestaurantsByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {
    List<Restaurant> handle(GetAllRestaurantsQuery query);
    Optional<Restaurant> handle(GetRestaurantByIdQuery query);
    Optional<Restaurant> handle(GetRestaurantsByNameQuery query);
}
