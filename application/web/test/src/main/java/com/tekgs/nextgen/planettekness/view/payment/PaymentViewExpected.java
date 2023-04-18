package com.tekgs.nextgen.planettekness.view.payment;

import com.tekgs.nextgen.planettekness.data.cart.PTCart;

import java.text.NumberFormat;
import java.util.Locale;

public class PaymentViewExpected implements PaymentViewCalibratable {
    private final int amount;

    public PaymentViewExpected(PTCart cart) {
        this.amount = cart != null ? cart.getTotal() : 0;
    }

    public static PaymentViewExpected getInstance() {
        return new PaymentViewExpected(null);
    }

    public static PaymentViewExpected getInstance(PTCart cart) {
        return new PaymentViewExpected(cart);
    }

    @Override
    public boolean isCurrencyUsd() {
        return true;
    }

    @Override
    public boolean isSourceFieldDisplayed() {
        return true;
    }

    @Override
    public String getAmount() {
        Locale locale = new Locale("en", "US");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(locale);
        return dollarFormat.format(amount / 100.0);
    }
}
