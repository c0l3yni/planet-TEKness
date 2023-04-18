package com.tekgs.nextgen.planettekness.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.planettekness.view.PTView;

public class ErrorView extends PTView implements ErrorViewCalibratable {
    private static final String DESCRIPTION = "'Error' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "error";
    private static final String RELATIVE_URI = "error";

    public ErrorView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ErrorView directNav() {
        new ErrorView().load();
        return UiView.expect(ErrorView.class);
    }

    @Override
    public String getErrorMessage() {
        String description = "'Error' message";
        String locatorValue = "error-message";
        return getElementById(description, locatorValue).getText();
    }

    @Override
    public String getCustomMessage() {
        String description = "'Custom Error' message";
        String locatorValue = "custom-message";
        return getElementById(description, locatorValue).getText();
    }
}
