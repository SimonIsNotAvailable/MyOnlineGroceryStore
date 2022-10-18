public enum ProductType {
    // Single-responsibility principle

    MILK ("Молоко, сыр"),
    BREAD ("Хлебобулочные изделия"),
    MEAT ("Мясо, птица"),
    FRUITS_VEGETABLES ("Фрукты и овощи"),
    FISH ("Рыба и морепродукты"),
    TEA_COFFEE ("Чай, кофе"),
    FROZEN ("Замороженные продукты"),
    DRINKS ("Напитки"),
    CONFECTIONERY ("Кондитерские изделия"),
    GROCERY ("Бакалея");

    private String title;

     ProductType (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}