package com.tekgs.nextgen.planettekness.view.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart' View";
    private final CartViewExpected expected;
    private final CartView actual;


    private CartViewCalibrator(CartViewExpected expected, CartView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CartViewCalibrator getInstance(CartViewExpected expected, CartView actual) {
        return new CartViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Cart' empty cart message", this.expected.getCartMessage(), this.actual.getCartMessage());
        verify("'Cart' get total amount", this.expected.getTotal(), this.actual.getTotal());
    }
}
