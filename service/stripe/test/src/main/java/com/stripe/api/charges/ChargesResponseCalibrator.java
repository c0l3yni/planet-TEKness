package com.stripe.api.charges;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ChargesResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Charges' Response";
    private final ChargesResponseExpected expected;
    private final ChargesResponse actual;

    private ChargesResponseCalibrator(ChargesResponseExpected expected, ChargesResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ChargesResponseCalibrator getInstance(ChargesResponseExpected expected, ChargesResponse actual) {
        return new ChargesResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("isPaymentSuccessful", expected.isPaymentSuccessful(), actual.isPaymentSuccessful());
    }
}
