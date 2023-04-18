package com.stripe.api.charges;

import com.google.gson.Gson;

public class Payment {

    private final String source;
    private final long amount;
    private final String currency;

    public Payment(long amount, String currency, String source) {
        this.amount = amount;
        this.currency = currency;
        this.source = source;
    }

    public static Payment getInstance(long amount, String currency, String source) {
        return new Payment(amount, currency, source);
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    public String getCurrency() {
        return currency;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }
}
