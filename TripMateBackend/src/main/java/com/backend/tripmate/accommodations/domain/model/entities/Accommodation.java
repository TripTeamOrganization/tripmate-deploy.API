package com.backend.tripmate.accommodations.domain.model.entities;

import com.backend.tripmate.accommodations.domain.model.commands.CreateAccommodationsCommand;
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

    @Column(name = "imagen", nullable = false)
    private String imagePath;

    @Column(name = "descripcion", length = 1500, nullable = false)
    private String description;

    @Column(name = "ubicacion", length = 150, nullable = false)
    private String ubicacion;

    @Column(name = "precio", length = 80, nullable = false)
    private String price;

    public Accommodation() {}

    public Accommodation(CreateAccommodationsCommand command) {
        this.name = command.getName();
        this.imagePath = command.getImagePath();
        this.description = command.getDescription();
        this.ubicacion = command.getUbicacion();
        this.price = command.getPrice();
    }

    public Accommodation updateInformation(String name, String imagePath, String description, String ubicacion, String price) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.ubicacion = ubicacion;
        this.price = price;
        return this;
    }
}