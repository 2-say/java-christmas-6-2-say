package christmas.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bilge {
    private LocalDate date;
    private Map<Menu, Integer> bilge;

    public Bilge(LocalDate date, Map<Menu, Integer> bilge) {
        this.date = date;
        this.bilge = bilge;
    }

    public Map<Menu, Integer> getBilge() {
        return bilge;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalPrice() {
        return bilge.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
