package com.backend.tripmate.activities.domain.model.entities;

import com.backend.tripmate.activities.domain.commands.CreateActivityCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "imagen",length = 5000, nullable = false)
    private String imagePath;

    @Column(name = "descripcion",length = 5000, nullable = false)
    private String description;

    @Column(name = "ubicacion",length = 5000, nullable = false)
    private String location;

    @Column(name = "precio", length = 50, nullable = false)
    private String price;

    public Activity(CreateActivityCommand command) {
        this.name = command.name();
        this.imagePath = command.imagePath();
        this.description = command.description();
        this.location = command.location();
        this.price = command.price();
    }

    public Activity() {
    }

    public Activity updateInformation(String name, String imagePath, String description, String location, String price) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.location = location;
        this.price = price;
        return this;
    }
}
