package christmas.validation;

public final class Validation {

    public static void validateDayInRange(int day) {
        if (day < 1 || day > 31){
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringToInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }




}
