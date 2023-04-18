package com.tekgs.planettekness.paymentservice;

public class PaymentResponseExpected implements PaymentResponseCalibratable {
    private final Payment payment;

    public PaymentResponseExpected(Payment payment) {
        this.payment = payment;
    }

    public static PaymentResponseExpected getInstance(Payment payment) {
        return new PaymentResponseExpected(payment);
    }

    @Override
    public boolean isSuccessfulResponse() {
        return payment.isValidPayment();
    }

    @Override
    public boolean isSuccessfulStatus() {
        return true;
    }
}
