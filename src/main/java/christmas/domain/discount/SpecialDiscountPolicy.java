package christmas.domain.discount;

import christmas.domain.Bilge;

public class SpecialDiscountPolicy implements DiscountPolicy{
    private int discountAmount = 1000;
    @Override
    public int discount(Bilge bilge, int price) {
        return bilge.getTotalPrice() - 1000;
    }
}
