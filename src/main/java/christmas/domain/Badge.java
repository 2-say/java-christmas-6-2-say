package christmas.domain;

import java.util.Arrays;

public enum Badge {
    STAR(5000),
    TREE(10000),
    SANTA(20000);

    private final int minimumBenefit;

    Badge(int minimumBenefit) {
        this.minimumBenefit = minimumBenefit;
    }

    public static Badge getBadgeByBenefit(int totalBenefit) {
        return Arrays.stream(values())
                .filter(badge -> totalBenefit >= badge.minimumBenefit)
                .findFirst()
                .orElse(null);
    }


}
