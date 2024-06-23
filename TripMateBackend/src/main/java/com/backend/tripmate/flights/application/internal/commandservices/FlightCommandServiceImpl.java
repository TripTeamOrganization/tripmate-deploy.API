package com.backend.tripmate.flights.application.internal.commandservices;

import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.DeleteFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.UpdateFlightCommand;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FlightCommandServiceImpl {
    private final FlightRepository flightRepository;

    public FlightCommandServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void handle(CreateFlightCommand createFlightCommand) {
        Flight flight = new Flight();
        flight.setNombreAerolinea(createFlightCommand.getNombreAerolinea());
        flight.setDescripcion(createFlightCommand.getDescripcion());
        flight.setPrecio(createFlightCommand.getPrecio());
        flightRepository.save(flight);
    }

    public void handle(UpdateFlightCommand updateFlightCommand) {
        Optional<Flight> optionalFlight = flightRepository.findById(updateFlightCommand.getId());
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flight.setNombreAerolinea(updateFlightCommand.getNombreAerolinea());
            flight.setDescripcion(updateFlightCommand.getDescripcion());
            flight.setPrecio(updateFlightCommand.getPrecio());
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("Flight not found with id: " + updateFlightCommand.getId());
        }
    }

    public void handle(DeleteFlightCommand deleteFlightCommand) {
        flightRepository.deleteById(deleteFlightCommand.getId());
    }
}
