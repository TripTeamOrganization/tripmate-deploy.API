package com.backend.tripmate.activities.interfaces.rest.transform;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.interfaces.rest.resources.ActivityResource;

public class ActivityResourceFromEntityAssembler {

    public static ActivityResource toResourceFromEntity(Activity entity) {
        return new ActivityResource(entity.getId(), entity.getName(), entity.getImagePath(), entity.getDescription(), entity.getLocation(), entity.getPrice());
    }
}
