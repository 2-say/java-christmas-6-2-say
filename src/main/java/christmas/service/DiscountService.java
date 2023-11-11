package christmas.service;

import christmas.domain.Bilge;
import christmas.domain.discount.*;
import christmas.utils.DateUtils;

import java.time.LocalDate;
import java.util.List;

public class DiscountService {
    private Bilge bilge;
    private List<DiscountPolicy> discountPolicies;

    public DiscountService(Bilge bilge) {
        this.bilge = bilge;
    }

    public void applyDiscount() {
        if (isDecemberAndInRange(bilge.getDate(), 1, 31)) {
            applyWeekdayDiscount();
            applyWeekendDiscount();
            applySpecialDiscount();
        }

        if (isChristmasSeason(bilge.getDate())) {
            discountPolicies.add(new ChristmasDiscountPolicy());
        }
    }

    private boolean isDecemberAndInRange(LocalDate date, int startDay, int endDay) {
        return DateUtils.isDecember(date) && DateUtils.isDayOfMonthInRange(date, startDay, endDay);
    }

    private void applyWeekdayDiscount() {
        if (DateUtils.isWeekday(bilge.getDate())) {
            discountPolicies.add(new WeekdayDiscountPolicy());
        }
    }

    private void applyWeekendDiscount() {
        if (DateUtils.isWeekend(bilge.getDate())) {
            discountPolicies.add(new WeekendDiscountPolicy());
        }
    }

    private void applySpecialDiscount() {
        if (DateUtils.isStarDay(bilge.getDate())) {
            discountPolicies.add(new SpecialDiscountPolicy());
        }
    }

    private boolean isChristmasSeason(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        return dayOfMonth >= 1 && dayOfMonth <= 25;
    }
}
