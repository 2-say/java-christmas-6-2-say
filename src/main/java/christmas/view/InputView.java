package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Utils;

public class InputView {
    public static String INPUT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요?";
    public static String INPUT_MENU_MESSAGE ="주문하실 메뉴와 개수를 알려 주세요.";

    public static void inputDayMessage() {
        System.out.println(INPUT_DAY_MESSAGE);
        String input = Console.readLine();
    }

    public static int inputMenuMessage() {
        System.out.println(INPUT_MENU_MESSAGE);
        String input = Console.readLine();
        return Utils.stringToInteger(input);
    }


}
