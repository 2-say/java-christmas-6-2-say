package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Bilge;
import christmas.utils.Utils;

import java.util.Map;

public class OutputView {

    final static String INFO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    final static String INFO_EVENT_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";


    public static void infoMessage() {
        System.out.println(INFO_MESSAGE);
    }

    public static void infoEventMessage() {
        System.out.println(INFO_EVENT_MESSAGE);
    }

    public static void printMenuQuantities(Bilge bilge) {
        System.out.println("\n<주문 메뉴>");
        bilge.getBilge().forEach((menu, quantity) -> System.out.println(menu.getName() + " " + quantity + "개"));
    }

    public static void printBeforeDiscount(Bilge bilge) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(Utils.moneyFormat(bilge.getTotalPrice()));
    }

    public static void printFreebie(boolean champagne) {
        System.out.println("\n<증정 메뉴>");
        if (champagne) {
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }
    }

    public static void printBenefitDetails(Map<String, Integer> discountDetails) {
        System.out.println("\n<혜택 내역>");
        if (isDiscountDetailsEmpty(discountDetails)) {
            System.out.println("없음");
        } else {
            for (Map.Entry<String, Integer> entry : discountDetails.entrySet()) {
                System.out.println(entry.getKey() + ": -" + Utils.moneyFormat(entry.getValue()));
            }
        }
    }

    public static boolean isDiscountDetailsEmpty(Map<String, Integer> discountDetails) {
        return discountDetails == null || discountDetails.isEmpty();
    }

    public static void printTotalBenefit(int totalDiscount) {
        System.out.println("\n<총혜택 금액>");
        if(totalDiscount==0) System.out.println(Utils.moneyFormat(totalDiscount));
        else System.out.println("-" + Utils.moneyFormat(totalDiscount));
    }

    public static void printAfterDiscount(int afterDiscount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(Utils.moneyFormat(afterDiscount));
    }

    public static void pringBadge(Badge badge) {
        System.out.println("\n<12월 이벤트 배지>");
        if (badge == null) {
            System.out.println("없음");
        } else {
            System.out.println(badge.badgeName);
        }
    }
}
