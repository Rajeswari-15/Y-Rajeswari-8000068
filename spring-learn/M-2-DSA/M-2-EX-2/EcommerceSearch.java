import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    static int linearSearch(Product[] products, String name) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    static int binarySearch(Product[] products, String name) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(name);

            if (result == 0)
                return mid;

            if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Mouse", "Accessories"),
                new Product(3, "Keyboard", "Accessories")
        };

        System.out.println("Linear Search: " +
                linearSearch(products, "Mouse"));

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        System.out.println("Binary Search: " +
                binarySearch(products, "Mouse"));
    }
}