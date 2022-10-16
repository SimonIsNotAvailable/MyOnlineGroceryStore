public class ProductBuilder {
        private Product newProduct;

        public ProductBuilder() {
            newProduct = new Product();
        }

        public ProductBuilder setDiscount(Discount discount) {
            newProduct.setDiscount(discount);
            return this;
        }

        public ProductBuilder setRating(int rating) {
            newProduct.setRating(rating);
            return this;
        }

        public ProductBuilder setFinalPrice(int finalPrice) {
            newProduct.setFinalPrice(finalPrice);
            return this;
        }

        public Product build() {
            return newProduct;
        }
    }
