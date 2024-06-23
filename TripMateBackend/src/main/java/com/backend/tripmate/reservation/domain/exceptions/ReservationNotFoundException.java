package com.backend.tripmate.reservation.domain.exceptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long id) {
        super("Reservation not found with id: " + id);
    }
}
