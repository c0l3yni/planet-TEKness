package com.tekgs.nextgen.planettekness.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public abstract class PTView extends UiView {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();

    protected PTView(String relativeUri, UiElement viewElement) {
        super(String.format("%s/%s", DOMAIN_URL, relativeUri), viewElement);
    }

    protected UiElement getElementById(String description, String locatorValue){
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
