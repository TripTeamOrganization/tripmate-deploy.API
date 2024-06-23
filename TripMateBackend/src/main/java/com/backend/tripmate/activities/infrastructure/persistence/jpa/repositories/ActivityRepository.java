package com.backend.tripmate.activities.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    boolean existsByName(String title);
}
