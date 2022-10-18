public interface ICart {
    public void addToCart(Product product, int quantity);
    public void deleteFromCart(int cartPosition);
    public void showCart();
}