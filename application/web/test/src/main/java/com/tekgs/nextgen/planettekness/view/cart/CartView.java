package com.tekgs.nextgen.planettekness.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.planettekness.view.PTView;

public class CartView extends PTView implements CartViewCalibratable {
    private static final String RELATIVE_URI = "cart";
    public static final String LOCATOR_VALUE = "cart";
    public static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Cart' View";

    public CartView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav(String cartId) {
        new CartView().load(String.format("?cart_id=%s", cartId));
        return UiView.expect(CartView.class);
    }

    public static CartView directNav() {
        new CartView().load();
        return UiView.expect(CartView.class);
    }

    @Override
    public String getCartMessage() {
        String description = "'Cart' Message";
        String locatorValue = "cart-message";
        return getElementById(description, locatorValue).getText();
    }

    @Override
    public String getTotal() {
        String description = "'Cart' total amount";
        String locatorValue = "cart-total-amount";
        return getElementById(description, locatorValue).getText();
    }
}
