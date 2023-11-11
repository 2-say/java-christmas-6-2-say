package christmas.domain.discount;

import christmas.domain.Bilge;

public class ChristmasDiscountPolicy implements DiscountPolicy{
    private static final int INITIAL_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;
    @Override
    public int discount(Bilge bilge, int price) {
        int dayOfMonth = bilge.getDate().getDayOfMonth();
        int totalDiscount = (dayOfMonth - 1) * DAILY_DISCOUNT_INCREASE;
        return Math.max(price - totalDiscount, 0);
    }
}
