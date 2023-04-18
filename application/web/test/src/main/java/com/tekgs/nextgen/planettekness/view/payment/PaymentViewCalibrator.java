package com.tekgs.nextgen.planettekness.view.payment;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment' view";
    private final PaymentViewExpected expected;
    private final PaymentView actual;

    private PaymentViewCalibrator(PaymentViewExpected expected, PaymentView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PaymentViewCalibrator getInstance(PaymentViewExpected expected, PaymentView actual) {
        return new PaymentViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Payment' currency is USD", this.expected.isCurrencyUsd(), this.actual.isCurrencyUsd());
        verify("'Payment' source field exists", this.expected.isSourceFieldDisplayed(), this.actual.isSourceFieldDisplayed());
        verify("'Payment' amount", this.expected.getAmount(), this.actual.getAmount());
    }
}
