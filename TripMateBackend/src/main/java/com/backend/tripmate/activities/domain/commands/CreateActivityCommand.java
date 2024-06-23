package com.backend.tripmate.activities.domain.commands;

public record CreateActivityCommand(String name, String imagePath, String description, String location, String price) {
}
