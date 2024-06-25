package com.backend.tripmate.flights.domain.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVuelo;

    private String nombreAerolinea;
    private String imagePath;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    private String precio;

    public Flight() {
    }

    // Getters and Setters
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Flight(String nombreAerolinea, String imagePath, String descripcion, String precio) {
        this.nombreAerolinea = nombreAerolinea;
        this.imagePath = imagePath;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}