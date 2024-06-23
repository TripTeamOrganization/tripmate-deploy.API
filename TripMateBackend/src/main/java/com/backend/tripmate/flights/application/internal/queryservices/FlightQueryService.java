package com.backend.tripmate.flights.application.internal.queryservices;

import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.domain.model.queries.GetAllFlightsQuery;
import com.backend.tripmate.flights.domain.model.queries.GetFlightByIdQuery;
import com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightQueryService {
    private final FlightRepository flightRepository;

    public FlightQueryService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> handle(GetAllFlightsQuery query) {
        return flightRepository.findAll();
    }

    public Flight handle(GetFlightByIdQuery query) {
        return flightRepository.findById(query.getId()).orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}
