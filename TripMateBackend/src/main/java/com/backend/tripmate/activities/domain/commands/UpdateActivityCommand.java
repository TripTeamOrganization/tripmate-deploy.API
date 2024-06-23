package com.backend.tripmate.activities.domain.commands;

public record UpdateActivityCommand(Long id, String name, String imagePath, String description, String location, String price) {
}
