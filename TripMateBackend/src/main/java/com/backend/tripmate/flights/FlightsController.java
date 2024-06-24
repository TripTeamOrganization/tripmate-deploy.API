package com.backend.tripmate.flights;

import com.backend.tripmate.flights.application.internal.commandservices.FlightCommandServiceImpl;
import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.DeleteFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.UpdateFlightCommand;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.domain.model.queries.GetAllFlightsQuery;
import com.backend.tripmate.flights.domain.model.queries.GetFlightByIdQuery;
import com.backend.tripmate.flights.application.internal.queryservices.FlightQueryService;
import com.backend.tripmate.flights.interfaces.rest.resources.CreateFlightResource;
import com.backend.tripmate.flights.interfaces.rest.resources.FlightResource;
import com.backend.tripmate.flights.interfaces.rest.resources.UpdateFlightResource;
import com.backend.tripmate.flights.interfaces.rest.transform.CreateFlightsCommandFromResourceAssembler;
import com.backend.tripmate.flights.interfaces.rest.transform.FlightResourceFromEntityAssembler;
import com.backend.tripmate.flights.interfaces.rest.transform.UpdateFlightsCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/flights", produces = APPLICATION_JSON_VALUE)
public class FlightsController {
    private final FlightQueryService flightQueryService;
    private final FlightCommandServiceImpl flightCommandServiceImpl;

    public FlightsController(FlightQueryService flightQueryService, FlightCommandServiceImpl flightCommandServiceImpl) {
        this.flightQueryService = flightQueryService;
        this.flightCommandServiceImpl = flightCommandServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<FlightResource>> getAllFlights() {
        var getAllFlightsQuery = new GetAllFlightsQuery();
        var flights = flightQueryService.handle(getAllFlightsQuery);
        var flightResources = flights.stream().map(FlightResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(flightResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResource> getFlightById(@PathVariable Integer id) {
        var getFlightByIdQuery = new GetFlightByIdQuery(id);
        Flight flight = flightQueryService.handle(getFlightByIdQuery);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }
        var flightResource = FlightResourceFromEntityAssembler.toResourceFromEntity(flight);
        return ResponseEntity.ok(flightResource);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createFlight(@RequestBody CreateFlightResource resource) {
        try {
            CreateFlightCommand command = CreateFlightsCommandFromResourceAssembler.toCommandFromResource(resource);
            flightCommandServiceImpl.handle(command);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFlight(@PathVariable Integer id, @RequestBody UpdateFlightResource resource) {
        try {
            UpdateFlightCommand command = UpdateFlightsCommandFromResourceAssembler.toCommandFromResource(id, resource);
            flightCommandServiceImpl.handle(command);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        try {
            var command = new DeleteFlightCommand(id);
            flightCommandServiceImpl.handle(command);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}