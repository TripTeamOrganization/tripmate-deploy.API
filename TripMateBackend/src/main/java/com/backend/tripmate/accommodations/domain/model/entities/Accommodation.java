package com.backend.tripmate.accommodations.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String name;

    @Column(name = "imagen", length = 500, nullable = false)
    private String imagePath;

    @Column(name = "descripcion", length = 1500, nullable = false)
    private String description;

    @Column(name = "ubicacion", length = 150, nullable = false)
    private String ubicacion;

    @Column(name = "precio", length = 80, nullable = false)
    private String price;
}
