package com.tekgs.planettekness.paymentservice;

import com.google.gson.Gson;

public class PaymentResponse implements PaymentResponseCalibratable {

    private final boolean isPaymentSuccessful;
    private int statusCode;

    public PaymentResponse(boolean isPaymentSuccessful) {
        this.isPaymentSuccessful = isPaymentSuccessful;
    }

    public static PaymentResponse getInstance(String responseJson, int status) {
        return new Gson().fromJson(responseJson, PaymentResponse.class).withStatusCode(status);
    }

    public PaymentResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    @Override
    public boolean isSuccessfulResponse() {
        return isPaymentSuccessful;
    }

    @Override
    public boolean isSuccessfulStatus() {
        return statusCode == 200;
    }
}
