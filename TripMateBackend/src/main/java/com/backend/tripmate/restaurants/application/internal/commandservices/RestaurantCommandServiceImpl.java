package com.backend.tripmate.restaurants.application.internal.commandservices;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.DeleteRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.domain.services.RestaurantCommandService;
import com.backend.tripmate.restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantCommandServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> handle(CreateRestaurantCommand command) {
        var restaurant = new Restaurant(command);
        if(restaurantRepository.existsByName(restaurant.getName())){
            throw new IllegalArgumentException("Restaurant already exists");
        }
        restaurantRepository.save(restaurant);
        return Optional.of(restaurant);
    }

    @Override
    public Optional<Restaurant> handle(UpdateRestaurantCommand command) {
        validateUpdateRestaurantCommand(command);
        var result = restaurantRepository.findById(command.id());
        if(result.isEmpty()){
            throw new IllegalArgumentException("Restaurant does not exist");
        }
        var restaurantToUpdate = result.get();
        try {
            var updatedRestaurant = restaurantRepository.save(restaurantToUpdate.updateInformation(command.name(), command.imagePath(), command.locationCost(), command.mustTry()));
            return Optional.of(updatedRestaurant);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating restaurant: " + e.getMessage());
        }
    }

    void validateUpdateRestaurantCommand(UpdateRestaurantCommand command) {
        if(command.id() == null) {
            throw new IllegalArgumentException("Restaurant id is required");
        }
        if(command.name() == null) {
            throw new IllegalArgumentException("Restaurant name is required");
        }
        if(command.imagePath() == null) {
            throw new IllegalArgumentException("Restaurant image is required");
        }
        if(command.locationCost() == null) {
            throw new IllegalArgumentException("Restaurant location cost is required");
        }
        if(command.mustTry() == null) {
            throw new IllegalArgumentException("Restaurant must try is required");
        }
    }

    @Override
    public void handle(DeleteRestaurantCommand command) {
        if(!restaurantRepository.existsById(command.id())){
            throw new IllegalArgumentException("Restaurant does not exist");
        }
        try {
            restaurantRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting restaurant: " + e.getMessage());
        }
    }

}
