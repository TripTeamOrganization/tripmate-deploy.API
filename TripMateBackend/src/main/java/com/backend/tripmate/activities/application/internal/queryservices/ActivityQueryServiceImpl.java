package com.backend.tripmate.activities.application.internal.queryservices;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.domain.model.queries.GetActivitiesByIdQuery;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;
import com.backend.tripmate.activities.domain.services.ActivityQueryService;
import com.backend.tripmate.activities.infrastructure.persistence.jpa.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityQueryServiceImpl implements ActivityQueryService {
    private final ActivityRepository activityRepository;

    public ActivityQueryServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> handle(GetAllActivitiesQuery query) {
        return activityRepository.findAll();
    }

    @Override
    public Optional<Activity> handle(GetActivitiesByIdQuery query) {
        return activityRepository.findById(query.id());
    }
}
