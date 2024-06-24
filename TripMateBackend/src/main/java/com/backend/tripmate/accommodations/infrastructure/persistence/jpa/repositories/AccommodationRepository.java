package com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
    boolean existsByName(String name);

}
