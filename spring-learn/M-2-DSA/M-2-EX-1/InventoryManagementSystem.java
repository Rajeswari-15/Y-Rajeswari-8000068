import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " " + productName + " Qty:" + quantity + " Price:" + price;
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    static void updateProduct(int id, int qty, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = qty;
            p.price = price;
        }
    }

    static void deleteProduct(int id) {
        inventory.remove(id);
    }

    static void displayProducts() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 55000));
        addProduct(new Product(102, "Mouse", 50, 500));

        updateProduct(101, 15, 56000);

        displayProducts();

        deleteProduct(102);

        System.out.println("\nAfter Deletion:");
        displayProducts();
    }
}