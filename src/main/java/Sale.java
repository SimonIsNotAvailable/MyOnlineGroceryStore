public class Sale implements ISaleType, ISaleSpecial{ // Interface segregation principle
    public void addSaleByType(int id, Discount discount) {
        Product withSale = new ProductBuilder()
                .setDiscount(discount)
                .build();
    }

    // Dependency inversion principle
    public void addSpecialOffer() {
        //TODO
    }
    public void removeSpecialOffer() {
        //TODO
    }
    public void removeSaleByType(){
        //TODO
    }
}