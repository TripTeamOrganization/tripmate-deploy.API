package com.backend.tripmate.reservation.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "price_details")
public class PriceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "cupon_descuento", length = 20)
    private String cuponDescuento;
}
