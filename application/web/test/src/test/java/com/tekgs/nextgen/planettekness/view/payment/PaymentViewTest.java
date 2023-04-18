package com.tekgs.nextgen.planettekness.view.payment;

import com.tekgs.nextgen.planettekness.data.cart.CartDefinition;
import com.tekgs.nextgen.planettekness.data.cart.PTCart;
import com.tekgs.nextgen.planettekness.data.cart.PTCartProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.PLANET_TEKNESS, GauntletTest.View.PAYMENT})
public class PaymentViewTest extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {CartDefinition.getInstance().withAmount(0)},
                {CartDefinition.getInstance().withAmount(50)},
                {CartDefinition.getInstance().withAmount(20100)},
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke(){
        addRequirements("293-payment-submission-collection");
        PaymentViewExpected expected = PaymentViewExpected.getInstance();
        PaymentView actual = PaymentView.directNav();
        then(PaymentViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition cartDefinition){
        addRequirements("293-payment-submission-collection");
        PTCart ptCart = PTCartProvider.getInstance().get(cartDefinition);
        given(ptCart);
        PaymentViewExpected expected = PaymentViewExpected.getInstance(ptCart);
        when();
        PaymentView actual = PaymentView.directNav(ptCart.getId());
        then(PaymentViewCalibrator.getInstance(expected, actual));
    }
}
