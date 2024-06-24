package com.backend.tripmate.flights.application.internal.commandservices;

import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.DeleteFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.UpdateFlightCommand;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightCommandServiceImpl {
    private final FlightRepository flightRepository;

    public FlightCommandServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Optional<Flight> handle(CreateFlightCommand command) {
        if(flightRepository.existsByNombreAerolinea(command.getNombreAerolinea())) {
            throw new IllegalArgumentException("Flight with same airline name already exists");
        }
        var flight = new Flight();
        flight.setNombreAerolinea(command.getNombreAerolinea());
        flight.setImagePath(command.getImagePath());
        flight.setDescripcion(command.getDescripcion());
        flight.setPrecio(command.getPrecio());
        try {
            flightRepository.save(flight);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving flight: " + e.getMessage());
        }
        return Optional.of(flight);
    }

    public Optional<Flight> handle(UpdateFlightCommand command) {
        validateUpdateCommand(command);
        var result = flightRepository.findById(command.getId());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Flight does not exist");
        }
        var flightToUpdate = result.get();
        flightToUpdate.setNombreAerolinea(command.getNombreAerolinea());
        flightToUpdate.setImagePath(command.getImagePath());
        flightToUpdate.setDescripcion(command.getDescripcion());
        flightToUpdate.setPrecio(command.getPrecio());
        try {
            var updatedFlight = flightRepository.save(flightToUpdate);
            return Optional.of(updatedFlight);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating flight: " + e.getMessage());
        }
    }

    private void validateUpdateCommand(UpdateFlightCommand command) {
        if (command.getId() == 0) {
            throw new IllegalArgumentException("Flight id is required");
        }
        if (command.getNombreAerolinea() == null) {
            throw new IllegalArgumentException("Airline name is required");
        }
        if (command.getImagePath() == null) {
            throw new IllegalArgumentException("Image path is required");
        }
        if (command.getDescripcion() == null) {
            throw new IllegalArgumentException("Description is required");
        }
        if (command.getPrecio() == null) {
            throw new IllegalArgumentException("Price is required");
        }
    }

    public void handle(DeleteFlightCommand command) {
        if (!flightRepository.existsById(command.getId())) {
            throw new IllegalArgumentException("Flight does not exist");
        }
        try {
            flightRepository.deleteById(command.getId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting flight: " + e.getMessage());
        }
    }
}