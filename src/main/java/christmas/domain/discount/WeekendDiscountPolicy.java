package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import christmas.utils.DateUtils;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 2023;
    public static final int START_DAY = 1;
    public static final int END_DAY = 31;

    @Override
    public int discount(Bilge bilge) {
        if (!DateUtils.isWeekend(bilge.getDate()) || !DateUtils.isDecemberAndInRange(bilge.getDate(), START_DAY, END_DAY)) {
            return 0;
        }
        return bilge.getBilge().entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == Menu.Category.MAIN)
                .mapToInt(entry -> discountAmount * entry.getValue())
                .sum();
    }

    public String getDescription() {
        return "주말 할인";
    }
}
