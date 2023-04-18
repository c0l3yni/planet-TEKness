package com.tekgs.nextgen.planettekness.view.error;

public class ErrorViewExpected implements ErrorViewCalibratable{


    private final boolean isUnexpectedError;

    public ErrorViewExpected(boolean isUnexpectedError) {
        this.isUnexpectedError = isUnexpectedError;
    }

    public static ErrorViewExpected getUnexpectedErrorInstance() {
        return new ErrorViewExpected(true);
    }

    public static ErrorViewExpected getInstance() {
        return new ErrorViewExpected(false);
    }

    @Override
    public String getErrorMessage() {
        return "Oops there was an error";
    }

    @Override
    public String getCustomMessage() {
        return isUnexpectedError ? "test error" : "Error 404: Page Not Found";
    }
}
