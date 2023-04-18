package com.tekgs.planettekness.paymentservice;

public class Payment {
    private final String currency;
    private final String source;
    private final long amount;

    public Payment(String currency, String source, long amount) {
        this.currency = currency;
        this.source = source;
        this.amount = amount;
    }

    public static Payment getInstance(String currency, String source, long amount) {
        return new Payment(currency, source, amount);
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

    public boolean isValidPayment() {
        boolean isValid = "tok_amex".equals(source);
        isValid &= "usd".equals(currency);
        isValid &= amount > 49L && amount < 1_000_000_00L;
        return isValid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "currency='" + currency + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }
}
