package com.backend.tripmate.reservation.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_tarjeta", length = 50, nullable = false)
    private String nombreTarjeta;

    @Column(name = "numero_tarjeta", length = 16, nullable = false)
    private String numeroTarjeta;

    @Column(name = "mes_expiracion", nullable = false)
    private int mesExpiracion;

    @Column(name = "ano_expiracion", nullable = false)
    private int anoExpiracion;

    @Column(name = "codigo_seguridad", length = 3, nullable = false)
    private String codigoSeguridad;

    @Column(name = "codigo_postal", length = 10, nullable = false)
    private String codigoPostal;
}
