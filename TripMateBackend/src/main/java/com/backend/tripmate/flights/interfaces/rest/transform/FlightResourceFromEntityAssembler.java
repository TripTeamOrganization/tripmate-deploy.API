package com.backend.tripmate.flights.interfaces.rest.transform;

import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.interfaces.rest.resources.FlightResource;

public class FlightResourceFromEntityAssembler {
    public static FlightResource toResourceFromEntity(Flight flight) {
        FlightResource resource = new FlightResource();
        resource.setIdVuelo(flight.getIdVuelo());
        resource.setNombreAerolinea(flight.getNombreAerolinea());
        resource.setDescripcion(flight.getDescripcion());
        resource.setPrecio(flight.getPrecio());
        return resource;
    }
}
