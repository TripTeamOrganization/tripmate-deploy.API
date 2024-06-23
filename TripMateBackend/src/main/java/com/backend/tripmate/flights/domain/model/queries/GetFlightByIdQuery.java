package com.backend.tripmate.flights.domain.model.queries;

public class GetFlightByIdQuery {
    private final int id;

    public GetFlightByIdQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
