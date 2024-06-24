package com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.flights.domain.model.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    boolean existsByNombreAerolinea(String nombreAerolinea);
}
