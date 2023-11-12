package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.utils.DateUtils;

import java.time.LocalDate;

public class ChristmasDiscountPolicy implements DiscountPolicy {
    private static final int INITIAL_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;
    public static final int START_DAY = 1;
    public static final int END_DAY = 25;

    @Override
    public int discount(Bilge bilge) {
        if (isChristmasSeason(bilge.getDate()) && DateUtils.isDecemberAndInRange(bilge.getDate(), START_DAY, END_DAY)) {
            int dayOfMonth = bilge.getDate().getDayOfMonth();
            int totalDiscount = (dayOfMonth - 1) * DAILY_DISCOUNT_INCREASE;
            return Math.max(INITIAL_AMOUNT + totalDiscount, 0);
        } else return 0;
    }

    public String getDescription() {
        return "크리스마스 디데이 할인";
    }

    private boolean isChristmasSeason(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        return dayOfMonth >= 1 && dayOfMonth <= 25;
    }
}
