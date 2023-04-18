package com.tekgs.nextgen.planettekness.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.planettekness.view.PTView;

public class ErrorGeneratorView extends PTView {
    private static final String RELATIVE_URI = "error-generator";
    private static final String DESCRIPTION = "'Error generator'";
    private static final String LOCATOR_VALUE = "body";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;

    public ErrorGeneratorView() {
        super(RELATIVE_URI,UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ErrorView directNav() {
        new ErrorGeneratorView().load();
        return UiView.expect(ErrorView.class);
    }
}
