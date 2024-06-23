package com.backend.tripmate.restaurants.application.internal.queryservices;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.backend.tripmate.restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.backend.tripmate.restaurants.domain.model.queries.GetRestaurantsByNameQuery;
import com.backend.tripmate.restaurants.domain.services.RestaurantQueryService;
import com.backend.tripmate.restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantQueryServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> handle(GetAllRestaurantsQuery query) {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantsByNameQuery query) {
        return restaurantRepository.findByName(query.name());
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByIdQuery query) {
        return restaurantRepository.findById(query.id());
    }
}
