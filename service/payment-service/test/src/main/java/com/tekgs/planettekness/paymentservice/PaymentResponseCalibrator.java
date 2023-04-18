package com.tekgs.planettekness.paymentservice;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentResponseCalibrator extends Calibrator {


    private static final String DESCRIPTION = "'Payment' response";
    private final PaymentResponse actual;
    private final PaymentResponseExpected expected;

    public PaymentResponseCalibrator(PaymentResponseExpected expected, PaymentResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PaymentResponseCalibrator getInstance(PaymentResponseExpected expected, PaymentResponse actual) {
        return new PaymentResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is successful response", expected.isSuccessfulResponse(), actual.isSuccessfulResponse());
        verify("Is status code 200", expected.isSuccessfulStatus(), actual.isSuccessfulStatus());
    }
}
