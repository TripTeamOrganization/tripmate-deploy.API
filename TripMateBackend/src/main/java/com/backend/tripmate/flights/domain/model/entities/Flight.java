package com.backend.tripmate.flights.domain.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVuelo;

    @Column(name = "nombreAerolinea", nullable = false, length = 100)
    private String nombreAerolinea;

    @Column(name = "imagePath", nullable = false, length = 250)
    private String imagePath;

    @Column(name = "descripcion", nullable = false, length = 1500)
    private String descripcion;

    @Column(name = "precio", nullable = false, length = 50)
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