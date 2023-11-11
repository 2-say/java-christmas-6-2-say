package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;

public class WeekendDiscountPolicy implements DiscountPolicy{

    private int discountAmount = 2023;
    @Override
    public int discount(Bilge bilge, int price) {
        return bilge.getBilge().stream()
                .filter(menu -> menu.getCategory() == Menu.Category.DESSERT)
                .mapToInt(menu -> price - discountAmount)
                .sum();
    }
}
