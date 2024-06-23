package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.iam.domain.model.aggregates.User;
import com.backend.tripmate.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.backend.tripmate.reservation.domain.model.commands.ReservationCommandService;
import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.PriceDetailsRepository;
import com.backend.tripmate.reservation.domain.model.entities.PaymentMethod;
import com.backend.tripmate.reservation.domain.model.entities.PriceDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PriceDetailsRepository priceDetailsRepository;
    private static final Logger logger = LoggerFactory.getLogger(ReservationCommandServiceImpl.class);

    @Autowired
    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, PaymentMethodRepository paymentMethodRepository, PriceDetailsRepository priceDetailsRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.priceDetailsRepository = priceDetailsRepository;
    }

    @Override
    public void handle(CreateReservationCommand command) {
        // Busca al usuario por su ID
        User user = userRepository.findById(command.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Crea un objeto PaymentMethod con los datos proporcionados
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(command.getPaymentMethod().getId());
        paymentMethod.setNombreTarjeta(command.getPaymentMethod().getNombreTarjeta());
        paymentMethod.setNumeroTarjeta(command.getPaymentMethod().getNumeroTarjeta());
        paymentMethod.setMesExpiracion(command.getPaymentMethod().getMesExpiracion());
        paymentMethod.setAnoExpiracion(command.getPaymentMethod().getAnoExpiracion());
        paymentMethod.setCodigoSeguridad(command.getPaymentMethod().getCodigoSeguridad());
        paymentMethod.setCodigoPostal(command.getPaymentMethod().getCodigoPostal());

        // Guarda el PaymentMethod en la base de datos
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        // Crea un objeto PriceDetails con los datos proporcionados
        PriceDetails priceDetails = new PriceDetails();
        priceDetails.setId(command.getPriceDetails().getId());
        // Verifica si el total es nulo y establece un valor predeterminado si es así
        if (command.getPriceDetails().getTotal() == null) {
            priceDetails.setTotal(0.0); // Valor predeterminado si total es nulo
        } else {
            priceDetails.setTotal(command.getPriceDetails().getTotal());
        }
        priceDetails.setCuponDescuento(command.getPriceDetails().getCuponDescuento());

        // Guarda el PriceDetails en la base de datos
        priceDetails = priceDetailsRepository.save(priceDetails);

        // Crea un objeto Reservation con los datos proporcionados
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setPaymentMethod(paymentMethod);
        reservation.setPriceDetails(priceDetails);

        // Guarda la Reservation en la base de datos
        reservationRepository.save(reservation);
    }
}
