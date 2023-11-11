package christmas.utils;

import christmas.validation.Validation;

public final class Utils {

    public static int stringToInteger(String input) {
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }
}
