package com.backend.tripmate.accommodations.application.internal.commandservices;

import com.backend.tripmate.accommodations.application.internal.queryservices.GetAccommodationByIdQuery;
import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.DeleteAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.commands.UpdateAccommodationsCommand;
import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationCommandServiceImpl {
    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationCommandServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public Accommodation getAccommodationById(GetAccommodationByIdQuery query) {
        return accommodationRepository.findById(query.getId())
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
    }

    public void createAccommodation(CreateAccommodationsCommand command) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(command.getNombre());
        accommodation.setImagePath(command.getImagen());
        accommodation.setDescription(command.getDescripcion());
        accommodation.setUbicacion(command.getUbicacion());
        accommodation.setPrice(command.getPrecio());
        accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(DeleteAccommodationsCommand command) {
        accommodationRepository.deleteById(command.getId());
    }

    public void updateAccommodation(UpdateAccommodationsCommand command) {
        Accommodation accommodation = accommodationRepository.findById(command.getId())
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        accommodation.setName(command.getNombre());
        accommodation.setImagePath(command.getImagen());
        accommodation.setDescription(command.getDescripcion());
        accommodation.setUbicacion(command.getUbicacion());
        accommodation.setPrice(command.getPrecio());
        accommodationRepository.save(accommodation);
    }
}
