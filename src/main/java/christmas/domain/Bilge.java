package christmas.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bilge {
    private LocalDate date;
    private Map<Menu, Integer> bilgeMap;

    public Bilge(LocalDate date, Map<Menu, Integer> bilgeMap) {
        this.date = date;
        this.bilgeMap = bilgeMap;
    }

    public Map<Menu, Integer> getBilge() {
        return bilgeMap;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalPrice() {
        return bilgeMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    private Map<Menu, Long> countMenuQuantities(List<Menu> bilge) {
        return bilge.stream()
                .collect(Collectors.groupingBy(menu -> menu, Collectors.counting()));
    }

    public void printMenuQuantities() {
        bilgeMap.forEach((menu, quantity) -> System.out.println(menu + ": " + quantity));
    }
}
