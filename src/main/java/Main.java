import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;

// Пользователь запрашивает список каталог,
// в каталоге выбирает раздел по типу продукта,
// выбирает и видит информацию о продукте,
// добавляет в корзину или идёт обратно, видит расчет, может удалить из корзины,
// узнать общую сумму скидки, стоимость доставки.

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Cart cart = Cart.get();
    private static List<Product> products;

    public static void main(String[] args) {

        String[] columnMapping = {"id", "productName", "price", "productType", "rating"};
        String fileName = "src/main/resources/data.csv";
        products = parseCSV(columnMapping, fileName); //Create products from the file

        while (true) {
            System.out.println("Добро пожаловать в магазин продуктов, выберите действие: \n" +
                    "1. Посмотреть каталог товаров\n" +
                    "2. Посмотреть корзину\n" +
                    "3. Выйти из программы");
            int input1 = scanner.nextInt();
            if (input1 == 3) {
                break;
            }
            switch (input1) {
                case 1:
                    showCatalogue();
                    break;
                case 2:
                    cart.showCart();
                    break;
            }
        }
    }

    public static List<Product> parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader data = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Product> ColPosStr = new ColumnPositionMappingStrategy<>();
            ColPosStr.setType(Product.class);
            ColPosStr.setColumnMapping(columnMapping);
            CsvToBean<Product> toBean = new CsvToBeanBuilder<Product>(data)
                    .withMappingStrategy(ColPosStr)
                    .build();
            return toBean.parse();
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;
    }

    public static void showCatalogue() {
        ProductType[] type = ProductType.values();
        int counter = 1;
        while (true) {
            System.out.println("Выбери категорию товара: \n" +
                    "Для возврата в предыдущее меню выбери '0'");
            for (ProductType productType : type) {
                System.out.println(counter++ + ". " + productType);
            }
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            } else {
                System.out.println("Выбери товар, а затем количество: \n" +
                        "Для возврата в предыдущее меню выбери '0'");
                List<Product> list = filterProductsByType(type[input - 1]);
                Product[] chosenProduct = new Product[list.size()];
                list.toArray(chosenProduct);
                counter = 1;
                int chosenProductNumber = scanner.nextInt();
                int quantity = scanner.nextInt();
                cart.addToCart(chosenProduct[chosenProductNumber - 1], quantity);
            }
        }
    }

    public static List<Product> filterProductsByType(ProductType chosenType) {
        final int[] count = {1};
        List<Product> filteredProducts = products.stream()
                .filter(t -> t.getProductType() == chosenType)
                .toList();
        filteredProducts.forEach(print -> System.out.println(count[0]++ + ". " + print + " "));
        return filteredProducts;
    }
}