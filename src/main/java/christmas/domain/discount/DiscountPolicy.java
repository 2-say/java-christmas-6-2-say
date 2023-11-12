package christmas.domain.discount;

import christmas.domain.Bilge;

public interface DiscountPolicy {
    /**
     * @param bilge
     * @retrun 할인 대상 금액
     */
    int discount(Bilge bilge);

    String getDescription();
}