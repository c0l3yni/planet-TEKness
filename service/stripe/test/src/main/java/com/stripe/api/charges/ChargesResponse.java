package com.stripe.api.charges;

import com.google.gson.Gson;

public class ChargesResponse implements ChargesResponseCalibratable{
    private final String status;
    private final boolean paid;

    private ChargesResponse(String status, boolean paid) {
        this.paid = paid;
        this.status = status;
    }

    public static ChargesResponse getInstance(String responseJson) {
        return new Gson().fromJson(responseJson, ChargesResponse.class);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return "succeeded".equals(status) && paid;
    }
}
