package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import christmas.utils.DateUtils;

import java.util.Map;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private int discountAmount = 2023;
    public static final int START_DAY = 1;
    public static final int END_DAY = 31;

    @Override
    public int discount(Bilge bilge) {
        if (!DateUtils.isWeekday(bilge.getDate()) || !DateUtils.isDecemberAndInRange(bilge.getDate(), START_DAY, END_DAY)) {
            return 0;
        }
        return bilge.getBilge().entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == Menu.Category.DESSERT)
                .mapToInt(entry -> discountAmount * entry.getValue())
                .sum();
    }

    public String getDescription() {
        return "평일 할인";
    }
}
