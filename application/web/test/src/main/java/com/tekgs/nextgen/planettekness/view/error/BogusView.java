package com.tekgs.nextgen.planettekness.view.error;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.planettekness.view.PTView;

public class BogusView extends PTView {
    private static final String BOGUS_ADDRESS = "bogusurl";
    private static final String LOCATOR_VALUE = "body";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String DESCRIPTION = "'Bogus' view";

    public BogusView() {
        super(BOGUS_ADDRESS, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }


    public static ErrorView directNav() {
        new BogusView().load();
        return UiView.expect(ErrorView.class);
    }

}
