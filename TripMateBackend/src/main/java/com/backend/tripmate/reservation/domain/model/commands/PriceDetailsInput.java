package com.backend.tripmate.reservation.domain.model.commands;

public class PriceDetailsInput {
    private Long id;
    private Double total;
    private String cuponDescuento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCuponDescuento() {
        return cuponDescuento;
    }

    public void setCuponDescuento(String cuponDescuento) {
        this.cuponDescuento = cuponDescuento;
    }
}
