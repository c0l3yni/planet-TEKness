package com.stripe.api.charges;

import org.softwareonpurpose.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ChargesResponseTest extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        long MIN_NOT_ALLOWED = 49L;
        long MIN_ALLOWED = 50L;
        long MAX_ALLOWED = 999_999_99L;
        long MAX_NOT_ALLOWED = 1_000_000_00L;
        long NEGATIVE = -50L;
        return new Object[][]{
                {MIN_NOT_ALLOWED},
                {MIN_ALLOWED},
                {MAX_ALLOWED},
                {MAX_NOT_ALLOWED},
                {NEGATIVE},
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        long amount = 50L;
        given(amount);
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amount);
        when();
        ChargesResponse actual = ChargesRequest.getInstance(amount).post();
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void post(long amount) {
        addRequirements("Payment Confirmation");
        given(amount);
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amount);
        when();
        ChargesResponse actual = ChargesRequest.getInstance(amount).post();
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }
}
