package com.tekgs.plantettekness.service.payment.data;

public class Payment {
    private final String currency;
    private final String source;
    private final long amount;

    public Payment(String currency, String source, long amount) {
        this.currency = currency;
        this.source = source;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSource() {
        return source;
    }

    public long getAmount() {
        return amount;
    }

}
