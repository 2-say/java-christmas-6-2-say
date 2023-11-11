package christmas.domain;

import java.util.List;

public class Bilge {
    private List<Menu> bilge;

    public Bilge(List<Menu> bilge) {
        this.bilge = bilge;
    }

    public List<Menu> getBilge() {
        return bilge;
    }
}
