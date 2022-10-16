public class Product {
    private int id;
    private String productName;
    private int price;
    private Discount discount;
    private int finalPrice;
    private ProductType productType;
    private int rating;
    private int quantity;

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Discount  getDiscount() {
        return discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getRating() {
        return rating;
    }
//продуктБилдер должен добавлять скидку, менять рейтинг
    //Название, стоимость, вес, скидка, тип продукта (молочное, хлебное), рейтинг, габарит, возможность доставки.


    public Product(int id, String productName, int price, ProductType productType, int rating) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.rating = rating;
    }

    public Product() {
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        Cart cart = Cart.get();
        return productName + ", " +
                price + "руб.," +
                quantity + " шт." +
                finalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==this) {
            return true;
        }
        if (obj == null|| obj.getClass() !=this.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return id == other.id;
    }
}