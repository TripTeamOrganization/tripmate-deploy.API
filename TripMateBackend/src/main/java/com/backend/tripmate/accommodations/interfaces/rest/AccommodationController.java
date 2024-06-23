package com.backend.tripmate.accommodations.interfaces.rest;

import com.backend.tripmate.accommodations.application.internal.commandservices.AccommodationCommandServiceImpl;
import com.backend.tripmate.accommodations.application.internal.queryservices.GetAccommodationByIdQuery;
import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.DeleteAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.UpdateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.domain.model.queries.GetAllAccommodationsQuery;
import com.backend.tripmate.accommodations.domain.services.AccommodationQueryService;
import com.backend.tripmate.accommodations.interfaces.rest.resources.AccommodationResource;
import com.backend.tripmate.accommodations.interfaces.rest.transform.AccommodationResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/accommodations", produces = APPLICATION_JSON_VALUE)
public class AccommodationController {

    private final AccommodationQueryService accommodationQueryService;
    private final AccommodationCommandServiceImpl accommodationCommandService;

    public AccommodationController(AccommodationQueryService accommodationQueryService, AccommodationCommandServiceImpl accommodationCommandService) {
        this.accommodationQueryService = accommodationQueryService;
        this.accommodationCommandService = accommodationCommandService;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationResource>> getAllAccommodations() {
        var getAllAccommodationsQuery = new GetAllAccommodationsQuery();
        var accommodations = accommodationQueryService.handle(getAllAccommodationsQuery);
        var accommodationResources = accommodations.stream()
                .map(AccommodationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(accommodationResources);
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodationById(@PathVariable Long id) {
        GetAccommodationByIdQuery query = new GetAccommodationByIdQuery(id);
        return accommodationCommandService.getAccommodationById(query);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAccommodation(@RequestBody CreateAccommodationsCommand command) {
        accommodationCommandService.createAccommodation(command);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccommodation(@PathVariable Long id, @RequestBody UpdateAccommodationsCommand command) {
        command.setId(id);
        accommodationCommandService.updateAccommodation(command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        var command = new DeleteAccommodationsCommand(id);
        accommodationCommandService.deleteAccommodation(command);
        return ResponseEntity.ok().build();
    }
}
