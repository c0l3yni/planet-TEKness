package com.tekgs.plantettekness.service.payment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse {
    private String status;
    private Boolean paid;

    public PaymentResponse() {
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getIsPaymentSuccessful() {
        return ("succeeded".equals(status) && paid);
    }
}
