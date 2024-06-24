package com.backend.tripmate.accommodations.interfaces.rest.resources;

public record CreateAccomodationsResource(String name, String imagePath, String description, String ubicacion, String price) {
}
