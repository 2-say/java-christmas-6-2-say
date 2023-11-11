package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class Bilge {
    private LocalDate date;
    private List<Menu> bilge;

    public Bilge(LocalDate date, List<Menu> bilge) {
        this.date = date;
        this.bilge = bilge;
    }

    public List<Menu> getBilge() {
        return bilge;
    }

    public LocalDate getDate() {
        return date;
    }
}
