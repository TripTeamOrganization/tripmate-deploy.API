package com.backend.tripmate.flights.domain.model.commands;

public class UpdateFlightCommand {
    private int id;
    private String nombreAerolinea;
    private String imagePath;
    private String descripcion;
    private String precio;

    public UpdateFlightCommand(int id, String nombreAerolinea, String imagePath, String descripcion, String precio) {
        this.id = id;
        this.nombreAerolinea = nombreAerolinea;
        this.imagePath = imagePath;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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