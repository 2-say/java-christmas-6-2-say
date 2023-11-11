package christmas.domain.discount;

public interface DiscountPolicy {
    /**
     * @param bilge
     * @param price
     * @retrun 할인 대상 금액
     */
    int discount(Bilge bilge , int price);
}