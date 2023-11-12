package christmas.utils;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import christmas.validation.Validation;

import java.text.DecimalFormat;
import java.util.*;

public final class Utils {

    public static String moneyFormat(int number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(number) + "원";
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static Map<Menu, Integer> processEntry(String entry) {
        Map<Menu, Integer> menuQuantities = new HashMap<>();
        Set<String> seenMenuNames = new HashSet<>();
        String[] menuEntries = splitEntry(entry);

        for (String menuEntry : menuEntries) {

            processMenuEntry(menuEntry, menuQuantities, seenMenuNames);
        }
        return menuQuantities;
    }

    private static void processMenuEntry(String menuEntry, Map<Menu, Integer> menuQuantities, Set<String> seenMenuNames) {
        String[] parts = splitMenuEntry(menuEntry);
        Validation.validateMenuFormat(parts);
        String menuName = extractMenuName(parts[0]);
        Validation.isNumeric(extractMenuName(parts[1]));
        int quantity = extractQuantity(parts[1]);
        Validation.checkDuplicateMenuName(seenMenuNames, menuName);
        validateAndProcessMenuEntry(menuName);
        Menu menuByName = findMenuByName(menuName);
        menuQuantities.put(menuByName, quantity);
    }

    private static Menu findMenuByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private static void validateAndProcessMenuEntry(String menuName) {
        Validation.validateMenuName(menuName);
    }


    private static String[] splitEntry(String entry) {
        return entry.split(",");
    }

    private static String[] splitMenuEntry(String menuEntry) {
        Validation.validateDashSplitter(menuEntry);
        return menuEntry.split("-");
    }

    private static String extractMenuName(String part) {
        return part.trim();
    }

    private static int extractQuantity(String part) {
        return Integer.parseInt(part.trim());
    }
}
