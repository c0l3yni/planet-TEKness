package com.tekgs.nextgen.planettekness.view.cart;

import com.tekgs.nextgen.planettekness.data.cart.CartDefinition;
import com.tekgs.nextgen.planettekness.data.cart.PTCart;
import com.tekgs.nextgen.planettekness.data.cart.PTCartProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.PLANET_TEKNESS, GauntletTest.View.CART})
public class CartViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {CartDefinition.getInstance().withAmount(0)},
                {CartDefinition.getInstance().withAmount(50)},
                {CartDefinition.getInstance().withAmount(20100)}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("310 Cart - Empty Cart Message");
        given();
        CartViewExpected expected = CartViewExpected.getInstance();
        when();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition cartDefinition){
        addRequirements("294-cart-total-amount");
        PTCart cart = PTCartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart.getId());
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}
