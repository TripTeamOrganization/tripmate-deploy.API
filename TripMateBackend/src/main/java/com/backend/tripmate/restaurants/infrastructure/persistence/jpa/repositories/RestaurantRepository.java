package com.backend.tripmate.restaurants.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);
    boolean existsById(Long id);
    boolean existsByName(String name);
}
