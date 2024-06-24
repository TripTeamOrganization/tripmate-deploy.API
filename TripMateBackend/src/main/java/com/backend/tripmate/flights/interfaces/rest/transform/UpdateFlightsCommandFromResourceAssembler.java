package com.backend.tripmate.flights.interfaces.rest.transform;

import com.backend.tripmate.flights.domain.model.commands.UpdateFlightCommand;
import com.backend.tripmate.flights.interfaces.rest.resources.UpdateFlightResource;

public class UpdateFlightsCommandFromResourceAssembler {
    public static UpdateFlightCommand toCommandFromResource(int id, UpdateFlightResource resource) {
        return new UpdateFlightCommand(
            id,
            resource.nombreAerolinea(),
            resource.imagePath(),
            resource.descripcion(),
            resource.precio()
        );
    }
}