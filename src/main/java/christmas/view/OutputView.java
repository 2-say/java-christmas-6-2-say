package christmas.view;

public class OutputView {

    final static String INFO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    final static String INFO_EVENT_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void infoMessage() {
        System.out.println(INFO_MESSAGE);
    }

    public static void infoEventMessage() {
        System.out.println(INFO_EVENT_MESSAGE);
    }
}
