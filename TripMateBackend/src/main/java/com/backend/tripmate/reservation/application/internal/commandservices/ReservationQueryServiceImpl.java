package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> handleGetAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> handleGetReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}