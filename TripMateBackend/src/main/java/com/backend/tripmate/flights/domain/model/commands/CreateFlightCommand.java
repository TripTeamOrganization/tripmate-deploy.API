package com.backend.tripmate.flights.domain.model.commands;

public class CreateFlightCommand {
    private String nombreAerolinea;
    private String imagePath;
    private String descripcion;
    private String precio;

    // Getters and Setters
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
