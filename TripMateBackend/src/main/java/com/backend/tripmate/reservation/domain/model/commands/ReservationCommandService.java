package com.backend.tripmate.reservation.domain.model.commands;

import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;

public interface ReservationCommandService {
    void handle(CreateReservationCommand command);
}
