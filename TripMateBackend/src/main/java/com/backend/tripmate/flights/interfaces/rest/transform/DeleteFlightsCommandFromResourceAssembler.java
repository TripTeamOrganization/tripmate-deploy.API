package com.backend.tripmate.flights.interfaces.rest.transform;

import com.backend.tripmate.flights.domain.model.commands.DeleteFlightCommand;
import com.backend.tripmate.flights.interfaces.rest.resources.DeleteFlightResource;

public class DeleteFlightsCommandFromResourceAssembler {
    public static DeleteFlightCommand toCommandFromResource(DeleteFlightResource resource) {
        return new DeleteFlightCommand(Math.toIntExact(resource.idVuelo()));
    }
}