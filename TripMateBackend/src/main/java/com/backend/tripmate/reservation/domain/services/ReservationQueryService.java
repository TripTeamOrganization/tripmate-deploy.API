package com.backend.tripmate.reservation.domain.services;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {
    List<Reservation> handleGetAllReservations();
    Optional<Reservation> handleGetReservationById(Long id);
}