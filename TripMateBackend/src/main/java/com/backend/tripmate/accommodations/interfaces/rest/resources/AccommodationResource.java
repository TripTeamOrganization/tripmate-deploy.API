package com.backend.tripmate.accommodations.interfaces.rest.resources;

public record AccommodationResource(Long id, String name, String imagePath, String description, String location, String price) {
}
