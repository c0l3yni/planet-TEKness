package com.tekgs.nextgen.planettekness.view.error;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.PLANET_TEKNESS, GauntletTest.View.ERROR})
public class ErrorViewTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke(){
        ErrorViewExpected expected = ErrorViewExpected.getInstance();
        ErrorView actual = ErrorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.DEBUG}, dependsOnMethods = "smoke")
    public void directNav(){
        addRequirements("300 Error Page - System Error");
        ErrorViewExpected expected = ErrorViewExpected.getUnexpectedErrorInstance();
        ErrorView actual = ErrorGeneratorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected,actual));
    }

    @Test(groups = {TestSuite.RELEASE, TestSuite.DEBUG}, dependsOnMethods = "smoke")
    public void invalidUrlDirectNav(){
        addRequirements("299 Error Page - Invalid URL");
        String bogusurl = "bogusurl";
        given(bogusurl);
        ErrorViewExpected expected = ErrorViewExpected.getInstance();
        when();
        ErrorView actual = BogusView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }
}
