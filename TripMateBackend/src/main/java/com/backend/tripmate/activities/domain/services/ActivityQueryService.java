package com.backend.tripmate.activities.domain.services;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.domain.model.queries.GetActivitiesByIdQuery;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;

import java.util.List;
import java.util.Optional;

public interface ActivityQueryService {
    List<Activity> handle(GetAllActivitiesQuery query);
    Optional<Activity> handle(GetActivitiesByIdQuery query);
}
