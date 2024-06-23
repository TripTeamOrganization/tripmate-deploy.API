package com.backend.tripmate.reservation.domain.model.commands;

public class PaymentMethodInput {
    private Long id;
    private String nombreTarjeta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Integer getMesExpiracion() {
        return mesExpiracion;
    }

    public void setMesExpiracion(Integer mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public Integer getAnoExpiracion() {
        return anoExpiracion;
    }

    public void setAnoExpiracion(Integer anoExpiracion) {
        this.anoExpiracion = anoExpiracion;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    private String numeroTarjeta;
    private Integer mesExpiracion;
    private Integer anoExpiracion;
    private String codigoSeguridad;
    private String codigoPostal;
}
