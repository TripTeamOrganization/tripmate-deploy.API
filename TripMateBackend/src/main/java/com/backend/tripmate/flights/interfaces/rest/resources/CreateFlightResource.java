package com.backend.tripmate.flights.interfaces.rest.resources;

public record CreateFlightResource(String nombreAerolinea, String imagePath, String descripcion, String precio) {
}
