package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.utils.DateUtils;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private int discountAmount = 1000;

    public static final int START_DAY = 1;
    public static final int END_DAY = 31;

    @Override
    public int discount(Bilge bilge) {
        if (DateUtils.isStarDay(bilge.getDate()) && DateUtils.isDecemberAndInRange(bilge.getDate(), START_DAY, END_DAY)) {
            return 1000;
        } else {
            return 0;
        }
    }

    public String getDescription() {
        return "특별 할인";
    }
}
