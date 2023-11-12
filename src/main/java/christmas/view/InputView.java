package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Utils;

public class InputView {
    private final static String INPUT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final static String INPUT_MENU_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static String inputDayMessage() {
        System.out.println(INPUT_DAY_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public static String inputMenuMessage() {
        System.out.println(INPUT_MENU_MESSAGE);
        String input = Console.readLine();
        return input;
    }


}
