package com.backend.tripmate.accommodations.domain.model.queries;

public class GetAccommodationByIdQuery {
    private final Long id;

    public GetAccommodationByIdQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}