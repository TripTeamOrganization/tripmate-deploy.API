package com.backend.tripmate.activities.interfaces.rest.resources;

public record CreateActivityResource(String name, String imagePath, String description, String location, String price) {
}
