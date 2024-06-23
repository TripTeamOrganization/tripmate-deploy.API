package com.backend.tripmate.flights;

import com.backend.tripmate.flights.application.internal.commandservices.FlightCommandServiceImpl;
import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.DeleteFlightCommand;
import com.backend.tripmate.flights.domain.model.commands.UpdateFlightCommand;
import com.backend.tripmate.flights.domain.model.queries.GetAllFlightsQuery;
import com.backend.tripmate.flights.domain.model.queries.GetFlightByIdQuery;
import com.backend.tripmate.flights.application.internal.queryservices.FlightQueryService;
import com.backend.tripmate.flights.interfaces.rest.resources.FlightResource;
import com.backend.tripmate.flights.interfaces.rest.transform.FlightResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        var flight = flightQueryService.handle(getFlightByIdQuery);
        var flightResource = FlightResourceFromEntityAssembler.toResourceFromEntity(flight);
        return ResponseEntity.ok(flightResource);
    }

    @PostMapping
    public ResponseEntity<FlightResource> createFlight(@RequestBody CreateFlightCommand createFlightCommand) {
        flightCommandServiceImpl.handle(createFlightCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFlight(@PathVariable Integer id, @RequestBody UpdateFlightCommand updateFlightCommand) {
        updateFlightCommand.setId(id);
        flightCommandServiceImpl.handle(updateFlightCommand);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        var deleteFlightCommand = new DeleteFlightCommand(id);
        flightCommandServiceImpl.handle(deleteFlightCommand);
        return ResponseEntity.noContent().build();
    }
}
