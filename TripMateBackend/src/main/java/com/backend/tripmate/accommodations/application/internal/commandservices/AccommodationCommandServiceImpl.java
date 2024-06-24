package com.backend.tripmate.accommodations.application.internal.commandservices;

import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.DeleteAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.UpdateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.domain.model.queries.GetAccommodationByIdQuery;
import com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccommodationCommandServiceImpl {
    private final AccommodationRepository accommodationRepository;

    public AccommodationCommandServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public Optional<Accommodation> getAccommodationById(GetAccommodationByIdQuery query) {
        return accommodationRepository.findById(query.getId());
    }

    public Optional<Accommodation> getAccommodationById(com.backend.tripmate.accommodations.application.internal.queryservices.GetAccommodationByIdQuery query) {
        return accommodationRepository.findById(query.getId());
    }

    public Optional<Accommodation> handle(CreateAccommodationsCommand command) {
        if(accommodationRepository.existsByName(command.getName())) {
            throw new IllegalArgumentException("Accommodation with same name already exists");
        }
        var accommodation = new Accommodation(command);
        try {
            accommodationRepository.save(accommodation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving accommodation: " + e.getMessage());
        }
        return Optional.of(accommodation);
    }

    public Optional<Accommodation> handle(UpdateAccommodationsCommand command) {
        validateUpdateCommand(command);
        var result = accommodationRepository.findById(command.getId());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Accommodation does not exist");
        }
        var accommodationToUpdate = result.get();
        try {
            var updatedAccommodation = accommodationRepository.save(accommodationToUpdate.updateInformation(command.getName(), command.getImagePath(), command.getDescription(), command.getUbicacion(), command.getPrice()));
            return Optional.of(updatedAccommodation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating accommodation: " + e.getMessage());
        }
    }

    private void validateUpdateCommand(UpdateAccommodationsCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException("Accommodation id is required");
        }
        if (command.getName() == null) {
            throw new IllegalArgumentException("Accommodation name is required");
        }
        if (command.getImagePath() == null) {
            throw new IllegalArgumentException("Accommodation image path is required");
        }
        if (command.getDescription() == null) {
            throw new IllegalArgumentException("Accommodation description is required");
        }
        if (command.getUbicacion() == null) {
            throw new IllegalArgumentException("Accommodation location is required");
        }
        if (command.getPrice() == null) {
            throw new IllegalArgumentException("Accommodation price is required");
        }
    }

    public void handle(DeleteAccommodationsCommand command) {
        if (!accommodationRepository.existsById(command.getId())) {
            throw new IllegalArgumentException("Accommodation does not exist");
        }
        try {
            accommodationRepository.deleteById(command.getId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting accommodation: " + e.getMessage());
        }
    }
}