package com.backend.tripmate.accommodations.domain.model.commands;

public class DeleteAccommodationsCommand {
    private final Long id;

    public DeleteAccommodationsCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
