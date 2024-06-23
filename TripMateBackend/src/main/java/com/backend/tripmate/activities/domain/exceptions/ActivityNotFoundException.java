package com.backend.tripmate.activities.domain.exceptions;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(Long id) {
        super("Activity with id " + id + " not found");
    }
}
