package com.tekgs.nextgen.planettekness.view.cart;

import com.tekgs.nextgen.planettekness.data.cart.PTCart;

import java.text.NumberFormat;
import java.util.Locale;

public class CartViewExpected implements CartViewCalibratable{
    private final int amount;
    private final PTCart cart;

    private CartViewExpected(PTCart cart) {
        this.amount = cart != null ? cart.getTotal() : 0;
        this.cart = cart;
    }

    public static CartViewExpected getInstance() {
        return new CartViewExpected(null);
    }

    public static CartViewExpected getInstance(PTCart cart) {
        return new CartViewExpected(cart);
    }

    @Override
    public String getCartMessage() {
        return cart == null || cart.isEmpty() ? "Your cart is empty" : "";
    }

    @Override
    public String getTotal() {
        Locale locale = new Locale("en", "US");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(locale);
        return dollarFormat.format(amount / 100.0);
    }
}
