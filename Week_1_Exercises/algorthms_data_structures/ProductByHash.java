import java.util.HashMap;
import java.util.Map;

public class ProductByHash {
    String productId;
    String productName;
    int quantity;
    double price;

    // Use HashMap for fast access
    private static Map<String, Product> inventory = new HashMap<>();

    public ProductByHash(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // add a product
    public static void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    // Update a product
    public static void updateProduct(Product updatedProduct) {
        if (inventory.containsKey(updatedProduct.productId)) {
            inventory.put(updatedProduct.productId, updatedProduct);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    // Delete a product
    public static void deleteProduct(String productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found in the inventory.");
        }
    }

    // Get a product by ID
    public static Product getProduct(String productId) {
        return inventory.get(productId);
    }

    // Get all products
    public static Map<String, Product> getAllProducts() {
        return new HashMap<>(inventory);
    }

    public static void main(String[] args) {
        
        Product product1 = new Product("001", "Widget", 10, 19.99);
        Product product2 = new Product("002", "Gadget", 20, 29.99);

        addProduct(product1);
        addProduct(product2);

        System.out.println("All products in inventory:");
        getAllProducts().values().forEach(product -> 
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
        getAllProducts().values().forEach(product -> 
            System.out.println("Product ID: " + product.productId + ", Name: " + product.productName + ", Quantity: " + product.quantity + ", Price: Rs" + product.price)
        );
    }
}
