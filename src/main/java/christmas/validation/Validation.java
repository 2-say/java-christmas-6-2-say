package christmas.validation;

import christmas.domain.Menu;
import christmas.view.ErrorView;

import java.util.Arrays;
import java.util.Set;

public final class Validation {

    public static void validateDayInRange(int day) {
        if (day < 1 || day > 31){
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringToInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            ErrorView.inputDayError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenuName(String name) {
        if (Arrays.stream(Menu.values())
                .noneMatch(menu -> menu.getName().equalsIgnoreCase(name))) {
            ErrorView.inputMenuError();
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicateMenuName(Set<String> seenMenuNames, String menuName) {
        if (!seenMenuNames.add(menuName)) {
            ErrorView.inputMenuError();
            throw new IllegalArgumentException();
        }
    }

    public static void isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ErrorView.inputMenuError();
            throw new IllegalArgumentException();
        }
    }


    public static void validateMenuFormat(String[] str) {
        if(str.length!=2){
            ErrorView.inputMenuError();
            throw new IllegalArgumentException();
        }
    }
    public static void validateDashSplitter(String input) {
        if (!input.contains("-")) {
            ErrorView.inputMenuError();
            throw new IllegalArgumentException();
        }
    }










}
