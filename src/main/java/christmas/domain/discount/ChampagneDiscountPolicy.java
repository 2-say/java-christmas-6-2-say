package christmas.domain.discount;

import christmas.domain.Bilge;

public class ChampagneDiscountPolicy implements DiscountPolicy{
    private int discountAmount = 25000;

    @Override
    public int discount(Bilge bilge) {
        return discountAmount;
    }

    @Override
    public String getDescription() {
        return "증정 이벤트";
    }
}
