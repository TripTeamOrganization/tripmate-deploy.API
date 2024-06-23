package com.backend.tripmate.reservation.domain.model.commands;

import com.backend.tripmate.reservation.domain.model.entities.PaymentMethod;
import com.backend.tripmate.reservation.domain.model.entities.PriceDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservationCommand {

    private Long userId;
    private PaymentMethodInput paymentMethod;
    private PriceDetailsInput priceDetails;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PaymentMethodInput getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodInput paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PriceDetailsInput getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(PriceDetailsInput priceDetails) {
        this.priceDetails = priceDetails;
    }
}
