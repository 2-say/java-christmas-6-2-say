package christmas.service;

import christmas.domain.Bilge;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.SpecialDiscountPolicy;
import christmas.domain.discount.WeekdayDiscountPolicy;
import christmas.domain.discount.WeekendDiscountPolicy;
import christmas.utils.DateUtils;

import java.util.List;

public class DiscountService {

    private Bilge bilge;
    private List<DiscountPolicy> discountPolicies;

    public DiscountService(Bilge bilge) {
        this.bilge = bilge;
    }

    public void events() {
        if (DateUtils.isDecember(bilge.getDate()) && DateUtils.isWeekday(bilge.getDate()) && DateUtils.isDayOfMonthInRange(bilge.getDate(), 1, 31)) {
            discountPolicies.add(new WeekdayDiscountPolicy());
        }

        if (DateUtils.isDecember(bilge.getDate()) && DateUtils.isWeekend(bilge.getDate()) && DateUtils.isDayOfMonthInRange(bilge.getDate(), 1, 31)) {
            discountPolicies.add(new WeekendDiscountPolicy());
        }

        if (DateUtils.isStarDay(bilge.getDate())) {
            discountPolicies.add(new SpecialDiscountPolicy());
        }




    }
}
