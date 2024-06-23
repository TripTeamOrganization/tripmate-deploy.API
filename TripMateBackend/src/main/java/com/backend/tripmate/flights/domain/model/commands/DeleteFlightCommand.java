package com.backend.tripmate.flights.domain.model.commands;

public class DeleteFlightCommand {
    private final int id;

    public DeleteFlightCommand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
