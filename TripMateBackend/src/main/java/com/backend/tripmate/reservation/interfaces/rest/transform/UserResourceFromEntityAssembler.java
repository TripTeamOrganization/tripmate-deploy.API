package com.backend.tripmate.reservation.interfaces.rest.transform;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(Reservation reservation) {
        return new UserResource(
            reservation.getId(),
            reservation.getUser().getUsername()
        );
    }
}