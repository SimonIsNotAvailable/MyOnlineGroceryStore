import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart {
    private int quantity;
    private List<Product> products = new ArrayList<>();
    private List<String> items;
    private Delivery delivery;
    private static Cart cart = null;

    public Cart() {

    }

    public static Cart get() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    @Override
    public void addToCart(Product product, int addQuantity) {
        for (int i = 0; i < products.size(); i++ ) {
            if (products.get(i).equals(product)) {
                product.setQuantity(addQuantity + products.get(i).getQuantity());
                products.add(product);
            }
        }
//        for (Product fromCart : products) {
//            if (product.equals(fromCart)) {
//                product.setQuantity(addQuantity + fromCart.getQuantity());
//                products.add(product);
//            }
//        }
        if (addQuantity > 1) {
            product.setQuantity(addQuantity);
            products.add(product);
        } else products.add(product);
    }

    @Override
    public void deleteFromCart() {
        //TODO
    }

    public void showCart() {
        products.forEach(System.out::println);
    }

    public int getQuantity() {
        return quantity;
    }
}