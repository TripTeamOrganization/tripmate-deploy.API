package com.backend.tripmate.reservation;

import com.backend.tripmate.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
import com.backend.tripmate.reservation.domain.exceptions.ReservationNotFoundException;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.domain.model.commands.PriceDetailsInput;
import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationCommandServiceImpl reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    @Autowired
    public ReservationController(ReservationCommandServiceImpl reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping("/api/v1/reservations")
    public void createReservation(@RequestBody CreateReservationCommand command) {
        PriceDetailsInput priceDetails = command.getPriceDetails();
        if (priceDetails.getTotal() == null) {
            priceDetails.setTotal(0.0);
        }
        reservationCommandService.handle(command);
    }

    @GetMapping("/api/v1/reservations")
    public List<Reservation> getAllReservations() {
        return reservationQueryService.handleGetAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        return reservationQueryService.handleGetReservationById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }
}