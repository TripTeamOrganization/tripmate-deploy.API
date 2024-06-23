package com.backend.tripmate.accommodations.application.internal.queryservices;

import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.domain.model.queries.GetAllAccommodationsQuery;
import com.backend.tripmate.accommodations.domain.services.AccommodationQueryService;
import com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationQueryServiceImpl implements AccommodationQueryService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationQueryServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Accommodation> handle(GetAllAccommodationsQuery query) {
        return accommodationRepository.findAll();
    }
}
