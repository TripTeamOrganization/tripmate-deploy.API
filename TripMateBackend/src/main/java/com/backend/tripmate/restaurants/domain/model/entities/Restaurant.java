package com.backend.tripmate.restaurants.domain.model.entities;

import com.backend.tripmate.restaurants.domain.model.commands.CreateRestaurantCommand;
import com.backend.tripmate.restaurants.domain.model.commands.UpdateRestaurantCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "imagePath", nullable = false)
    private String imagePath;

    @Column(name = "locationCost", nullable = false)
    private String locationCost;

    @Column(name = "mustTry", length = 50, nullable = false)
    private String mustTry;

    public Restaurant(CreateRestaurantCommand command) {
        this.name = command.name();
        this.imagePath = command.imagePath();
        this.locationCost = command.locationCost();
        this.mustTry = command.mustTry();
    }

    public Restaurant() {
    }

    public Restaurant(String name, String imagePath, String locationCost, String mustTry) {
        this.name = name;
        this.imagePath = imagePath;
        this.locationCost = locationCost;
        this.mustTry = mustTry;
    }

    public Restaurant updateInformation(String name, String imagePath, String locationCost, String mustTry) {
        this.name = name;
        this.imagePath = imagePath;
        this.locationCost = locationCost;
        this.mustTry = mustTry;
        return this;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLocationCost() {
        return locationCost;
    }

    public void setLocationCost(String locationCost) {
        this.locationCost = locationCost;
    }

    public String getMustTry() {
        return mustTry;
    }

    public void setMustTry(String mustTry) {
        this.mustTry = mustTry;
    }
}