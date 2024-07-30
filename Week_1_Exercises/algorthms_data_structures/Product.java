import java.util.ArrayList;
import java.util.List;

public class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public static ArrayList<Product> inventory = new ArrayList<>();

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // add a product
    public static void addProduct(Product product) {
        inventory.add(product);
    }

    // Update
    public static void updateProduct(Product updatedProduct) {
        for (int i = 0; i < inventory.size(); i++) {
            Product product = inventory.get(i);
            if (product.productId.equals(updatedProduct.productId)) {
                inventory.set(i, updatedProduct);
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    // Delete
    public static void deleteProduct(String productId) {
        for (int i = 0; i < inventory.size(); i++) {
            Product x = inventory.get(i);
            if (x.productId.equals(productId)) {
                inventory.remove(i);
                break;
            }
        }
    }
    // Get a product by ID
    public static Product getProduct(String productId) {
        for (Product product : inventory) {
            if (product.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Get all products
    public static List<Product> getAllProducts() {
        return new ArrayList<>(inventory);
    }

    public static void main(String[] args) {
        Product product1 = new Product("001", "Widget", 10, 19.99);
        Product product2 = new Product("002", "Gadget", 20, 29.99);

        addProduct(product1);
        addProduct(product2);

        System.out.println("All products in inventory:");
        getAllProducts().forEach(product -> 
            System.out.println("Product ID: " + product.productId + ", Name: " + product.productName + ", Quantity: " + product.quantity + ", Price: Rs" + product.price)
        );

        // Update
        product1.quantity = 15;
        updateProduct(product1);

        System.out.println("Updated product:");
        Product updatedProduct = getProduct("001");
        if (updatedProduct != null) {
            System.out.println("Product ID: " + updatedProduct.productId + ", Name: " + updatedProduct.productName + ", Quantity: " + updatedProduct.quantity + ", Price: Rs" + updatedProduct.price);
        }

        // Delete
        deleteProduct("002");

        System.out.println("All products in inventory after deletion:");
        inventory.forEach(product -> 
            System.out.println("Product ID: " + product.productId + ", Name: " + product.productName + ", Quantity: " + product.quantity + ", Price: Rs" + product.price)
        );
    }
}
