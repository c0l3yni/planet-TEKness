package com.tekgs.nextgen.planettekness.view.payment;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.planettekness.view.PTView;

public class PaymentView extends PTView implements PaymentViewCalibratable {
    private static final String RELATIVE_URI = "payment";
    private static final String DESCRIPTION = "'Payment' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "payment";

    public PaymentView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PaymentView directNav() {
        new PaymentView().load();
        return UiView.expect(PaymentView.class);
    }

    public static PaymentView directNav(String id) {
        new PaymentView().load(String.format("?cart_id=%s", id));
        return UiView.expect(PaymentView.class);
    }
    
    @Override
    public boolean isCurrencyUsd() {
        return getAmountElement().getText().contains("$");
    }

    @Override
    public boolean isSourceFieldDisplayed() {
        String description = "source field";
        String locatorValue = "source-field";
        return getElementById(description, locatorValue).isDisplayed();
    }

    @Override
    public String getAmount() {
        return getAmountElement().getText();
    }

    private UiElement getAmountElement() {
        String description = "amount";
        String locatorValue = "amount";
        return getElementById(description, locatorValue);
    }
}
