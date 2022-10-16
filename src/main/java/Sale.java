public class Sale implements ISaleType, ISaleSpecial{
    public void addSaleByType(int id, Discount discount) {
        Product withSale = new ProductBuilder()
                .setDiscount(discount)
                .build();
    }
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