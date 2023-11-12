package christmas.view;

public class ErrorView {

    final static String INPUT_DAY_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    final static String INPUT_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void inputDayError() {
        System.out.println(INPUT_DAY_ERROR_MESSAGE);
    }

    public static void inputMenuError() {
        System.out.println(INPUT_MENU_ERROR_MESSAGE);
    }


}
