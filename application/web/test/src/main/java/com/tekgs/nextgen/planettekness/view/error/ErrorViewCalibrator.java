package com.tekgs.nextgen.planettekness.view.error;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ErrorViewCalibrator extends Calibrator {
    public static final String DESCRIPTION = "'Error' view";
    private final ErrorViewExpected expected;
    private final ErrorView actual;

    protected ErrorViewCalibrator(ErrorViewExpected expected, ErrorView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ErrorViewCalibrator getInstance(ErrorViewExpected expected, ErrorView actual) {
        return new ErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Error' message displayed", expected.getErrorMessage(), actual.getErrorMessage());
        verify("'Custom Error' message", expected.getCustomMessage(), actual.getCustomMessage());
    }
}
