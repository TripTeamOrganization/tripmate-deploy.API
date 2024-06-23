package com.backend.tripmate.reservation.domain.model.entities;

import com.backend.tripmate.iam.domain.model.aggregates.User;
import com.backend.tripmate.reservation.domain.model.entities.PaymentMethod;
import com.backend.tripmate.reservation.domain.model.entities.PriceDetails;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "price_details_id", nullable = false)
    private PriceDetails priceDetails;

    @Column(name = "total", nullable = false)
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "cupon_descuento", length = 20)
    private String cuponDescuento;
}
