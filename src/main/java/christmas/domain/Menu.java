package christmas.domain;

public enum Menu {
    YANGSONGISOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESARSALAD("시저샐러드", 8000, Category.APPETIZER),
    TIBONESTEAK("티본스테이크", 55000, Category.MAIN),
    BARBECUERIB("바비큐립", 54000, Category.MAIN),
    SEAFOODPASTA("해산물파스타", 35000, Category.MAIN),
    CHRISTMASPASTA("크리스마스파스타", 25000, Category.MAIN),
    CHOCOCAKE("초코케이크", 15000, Category.DESSERT),
    ICECREAM("아이스크림", 5000, Category.DESSERT),
    ZEROCOLA("제로콜라", 3000, Category.DRINK),
    REDWINE("레드와인", 60000, Category.DRINK),
    CHAMPAGNE("샴페인", 25000, Category.DRINK);

    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category {
        APPETIZER,
        MAIN,
        DESSERT,
        DRINK
    }
}
