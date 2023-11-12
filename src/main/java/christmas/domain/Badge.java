package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별");

    private final int minimumBenefit;
    public final String badgeName;

    Badge(int minimumBenefit, String badgeName) {
        this.minimumBenefit = minimumBenefit;
        this.badgeName = badgeName;
    }

    public static Badge getBadgeByBenefit(int totalBenefit) {
        return Arrays.stream(values())
                .filter(badge -> totalBenefit >= badge.minimumBenefit)
                .findFirst()
                .orElse(null);
    }


}
