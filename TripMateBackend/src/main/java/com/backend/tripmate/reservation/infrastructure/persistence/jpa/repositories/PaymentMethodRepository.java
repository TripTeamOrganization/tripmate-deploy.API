package com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.reservation.domain.model.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
