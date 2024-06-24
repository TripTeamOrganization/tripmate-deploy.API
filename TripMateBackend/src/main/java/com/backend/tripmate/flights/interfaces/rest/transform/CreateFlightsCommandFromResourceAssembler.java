package com.backend.tripmate.flights.interfaces.rest.transform;

import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.interfaces.rest.resources.CreateFlightResource;

public class CreateFlightsCommandFromResourceAssembler {
    public static CreateFlightCommand toCommandFromResource(CreateFlightResource resource) {
        return new CreateFlightCommand(
            resource.nombreAerolinea(),
            resource.imagePath(),
            resource.descripcion(),
            resource.precio()
        );
    }
}