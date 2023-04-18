package com.stripe.api.charges;

public class ChargesResponseExpected implements ChargesResponseCalibratable{
    private final long amount;

    public ChargesResponseExpected(long amount) {
        this.amount = amount;
    }

    public static ChargesResponseExpected getInstance(long amount) {
        return new ChargesResponseExpected(amount);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return amount >= 50 && amount <= 999_999_99L;
    }
}
