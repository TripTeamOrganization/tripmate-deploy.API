package com.backend.tripmate.restaurants.domain.model.entities;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.UpdateRestaurantCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "imagen", length = 50, nullable = false)
    private String image;

    @Column(name = "locationCost", length = 50, nullable = false)
    private String locationCost;

    @Column(name = "mustTry", length = 50, nullable = false)
    private String mustTry;

    public Restaurant(CreateRestaurantCommand command) {
        this.name = command.name();
        this.image = command.image();
        this.locationCost = command.locationCost();
        this.mustTry = command.mustTry();
    }

    public Restaurant() {

    }

    public Restaurant updateInformation(String name, String image, String locationCost, String mustTry) {
        this.name = name;
        this.image = image;
        this.locationCost = locationCost;
        this.mustTry = mustTry;
        return this;
    }
}
