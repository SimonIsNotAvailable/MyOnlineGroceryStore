public interface ICart {
     void addToCart(Product product, int quantity);
     void deleteFromCart(int cartPosition);
     void showCart();
}