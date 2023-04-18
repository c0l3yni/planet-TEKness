package com.tekgs.planettekness.paymentservice;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.PAYMENT, GauntletTest.Endpoint.PURCHASE})
public class PaymentServiceTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {Payment.getInstance("usd", "tok_amex", 999_999_99L)},
                {Payment.getInstance("usd", "tok_amex", 49L)},
                {Payment.getInstance("usd", "tok_amex", 1_000_000_00L)},
                {Payment.getInstance("usd", "invalid", 50L)},
                {Payment.getInstance("invalid", "tok_amex", 50L)},
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("291 - Payment Service");
        Payment payment = Payment.getInstance("usd", "tok_amex", 50L);
        given(payment);
        PaymentResponseExpected expected = PaymentResponseExpected.getInstance(payment);
        when();
        PaymentResponse actual = PaymentRequest.getInstance(payment).post();
        then(PaymentResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void post(Payment payment) {
        addRequirements("291 - Payment Service");
        given(payment);
        PaymentResponseExpected expected = PaymentResponseExpected.getInstance(payment);
        when();
        PaymentResponse actual = PaymentRequest.getInstance(payment).post();
        then(PaymentResponseCalibrator.getInstance(expected, actual));
    }
}
