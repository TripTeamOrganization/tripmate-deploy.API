package com.backend.tripmate.activities.interfaces.rest.resources;

public record ActivityResource(Long id, String name, String imagePath, String description, String location, String price) {
}
