package com.backend.tripmate.reservation;

import com.backend.tripmate.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
import com.backend.tripmate.reservation.domain.exceptions.ReservationNotFoundException;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.domain.model.commands.PriceDetailsInput;
import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing reservations.
 *
 * @author Jeremy Joel Quispe Andia
 * @version 1.0
 */
@RestController
public class ReservationController {

    private final ReservationCommandServiceImpl reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    /**
     * Constructor for ReservationController.
     *
     * @param reservationCommandService the reservation command service
     * @param reservationQueryService the reservation query service
     */
    @Autowired
    public ReservationController(ReservationCommandServiceImpl reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    /**
     * Create a new reservation.
     *
     * @param command the reservation command
     */
    @PostMapping("/api/v1/reservations")
    public void createReservation(@RequestBody CreateReservationCommand command) {
        PriceDetailsInput priceDetails = command.getPriceDetails();
        if (priceDetails.getTotal() == null) {
            priceDetails.setTotal(0.0);
        }
        reservationCommandService.handle(command);
    }

    /**
     * Get all reservations.
     *
     * @return a list of all reservations
     */
    @GetMapping("/api/v1/reservations")
    public List<Reservation> getAllReservations() {
        return reservationQueryService.handleGetAllReservations();
    }

    /**
     * Get a reservation by its id.
     *
     * @param id the id of the reservation
     * @return the reservation with the given id
     */
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        return reservationQueryService.handleGetReservationById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }
}