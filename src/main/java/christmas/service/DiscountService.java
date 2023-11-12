package christmas.service;

import christmas.domain.Bilge;
import christmas.domain.discount.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountService {
    private Bilge bilge;
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public DiscountService(Bilge bilge) {
        this.bilge = bilge;
    }

    public int applyDiscount() {
        OngoingEventList();
        cleanDiscount();
        return calculateDiscountedPrice();
    }

    public Map<String, Integer> getDiscountDetails() {
        Map<String, Integer> discountDetails = new HashMap<>();
        discountPolicies.forEach(policy -> discountDetails.put(policy.getDescription(), policy.discount(bilge)));
        return discountDetails;
    }

    public int calculateNoneChampagneDiscount() {
        return discountPolicies.stream()
                .filter(policy -> !(policy instanceof ChampagneDiscountPolicy))
                .mapToInt(policy -> policy.discount(bilge))
                .sum();
    }

    private void OngoingEventList() {
        discountPolicies.add(new SpecialDiscountPolicy());
        discountPolicies.add(new WeekendDiscountPolicy());
        discountPolicies.add(new WeekdayDiscountPolicy());
        discountPolicies.add(new ChristmasDiscountPolicy());
        if (calculateDiscountedPrice() >= 120_000)
            discountPolicies.add(new ChampagneDiscountPolicy());
    }

    private int cleanDiscount() {
        discountPolicies.removeIf(policy -> policy.discount(bilge) == 0);
        return calculateDiscountedPrice();
    }

    private int calculateDiscountedPrice() {
        return discountPolicies.stream()
                .mapToInt(policy -> policy.discount(bilge))
                .sum();
    }

    public boolean hasChampagneDiscount() {
        return discountPolicies.stream()
                .anyMatch(policy -> policy instanceof ChampagneDiscountPolicy);
    }


}
