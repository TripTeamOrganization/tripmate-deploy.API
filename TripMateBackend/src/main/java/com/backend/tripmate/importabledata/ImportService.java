package com.backend.tripmate.importabledata;
import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories.AccommodationRepository;
import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.infrastructure.persistence.jpa.repositories.ActivityRepository;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;




@Service
public class ImportService {

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper autowired by Spring Boot

    @Autowired
    private AccommodationRepository accommodationRepository; // Inject repositories directly
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public void importAccommodations(List<Accommodation> accommodations) {
        saveEntities(accommodations.toArray(new Accommodation[0]), accommodationRepository);
    }

    @Transactional
    public void importActivities(List<Activity> activities) {
        saveEntities(activities.toArray(new Activity[0]), activityRepository);
    }

    @Transactional
    public void importFlights(List<Flight> flights) {
        saveEntities(flights.toArray(new Flight[0]), flightRepository);
    }

    @Transactional
    public void importRestaurants(List<Restaurant> restaurants) {
        saveEntities(restaurants.toArray(new Restaurant[0]), restaurantRepository);

    }


    private <S> void saveEntities(S[] entities, JpaRepository<S, ?> repository) {
        repository.saveAll(Arrays.asList(entities));
    }
}