import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cart implements ICart {

    private List<Product> products = new ArrayList<>();
    private static Cart cart = null;
    private static int newQuantity;
    private int totalPrice;

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

        if (products.contains(product)){
            newQuantity = product.getQuantity() + addQuantity;
            product.setQuantity(newQuantity);
            newQuantity = 0;
        } else {
            product.setQuantity(addQuantity);
            products.add(product);
        }
    }

    @Override
    public void deleteFromCart(int cartPosition) {
        products.remove(cartPosition - 1);
    }

    public void showCart() {
        int number = 1;
        printStripe();
        for (Product product : products) {
            System.out.println(number++ + ". " + product);
        }
        calculateTotalPrice();
        System.out.println("Итого:  " + totalPrice + " рублей");
        printStripe();
        System.out.println("Для удаления из корзины выбери позицию или 0 для возврата в главное меню");
        Scanner cartScanner = new Scanner(System.in);
        int cartInput = cartScanner.nextInt();
        if (cartInput == 0) {
            return;
        } else if (cartInput < 0 || cartInput > products.size()) {
            throw new IndexOutOfBoundsException("Неверный ввод");
        } else {
            deleteFromCart(cartInput);
        }
    }

    public void calculateTotalPrice() {
        totalPrice = 0;
        for (Product product : products) {
            totalPrice = totalPrice + (product.getQuantity() * product.getPrice());
        }
    }

    public void printStripe() {
        System.out.println("---------------------------");  // принцип DRY
    }
}