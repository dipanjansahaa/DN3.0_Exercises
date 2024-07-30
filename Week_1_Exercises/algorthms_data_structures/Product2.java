import java.util.Arrays;

public class Product2 {
    private String productId;
    private String productName;
    private String category;

    public Product2(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Linear search method using traditional for loop
    public static Product2 linearSearch(Product2[] products, String productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId.equals(productId)) {
                return products[i];
            }
        }
        return null; // Product2 not found
    }

    // Binary search method
    public static Product2 binarySearch(Product2[] products, String productId) {
        
        Arrays.sort(products, (p1, p2) -> p1.productId.compareTo(p2.productId));

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midProductId = products[mid].productId;

            if (midProductId.equals(productId)) {
                return products[mid];
            } else if (midProductId.compareTo(productId) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Product2 not found
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create sample products
        Product2 p1 = new Product2("002", "Gadget", "Electronics");
        Product2 p2 = new Product2("001", "Widget", "Tools");
        Product2 p3 = new Product2("003", "Doodad", "Toys");

        // Store products in an array
        Product2[] products = { p1, p2, p3 };

        // Perform linear search
        Product2 resultLinear = linearSearch(products, "001");
        System.out.println("Linear Search Result: " + (resultLinear != null ? 
            "Product ID: " + resultLinear.productId + 
            ", Name: " + resultLinear.productName + 
            ", Category: " + resultLinear.category : 
            "Product not found"));

        // Perform binary search
        Product2 resultBinary = binarySearch(products, "003");
        System.out.println("Binary Search Result: " + (resultBinary != null ? 
            "Product2 ID: " + resultBinary.productId + 
            ", Name: " + resultBinary.productName + 
            ", Category: " + resultBinary.category : 
            "Product not found"));
    }
}
