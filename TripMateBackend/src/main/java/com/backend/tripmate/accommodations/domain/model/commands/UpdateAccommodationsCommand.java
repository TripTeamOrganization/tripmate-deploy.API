package com.backend.tripmate.accommodations.domain.model.commands;

public class UpdateAccommodationsCommand {
    private Long id;
    private String name;
    private String imagePath;
    private String description;
    private String ubicacion;
    private String price;

    public UpdateAccommodationsCommand(Long id, String name, String imagePath, String description, String ubicacion, String price) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.ubicacion = ubicacion;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
