package com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.reservation.domain.model.entities.PriceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDetailsRepository extends JpaRepository<PriceDetails, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}