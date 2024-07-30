import java.util.Arrays;

public class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Bubble Sort
    public static void bubbleSortbooks(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSortbooks(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSortbooks(orders, low, pi - 1);
            quickSortbooks(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 200.0),
                new Order(4, "David", 300.0)
        };

        System.out.println("Original orders:");
        System.out.println(Arrays.toString(orders));

        bubbleSortbooks(orders);
        System.out.println("\nbooks after Bubble Sort:");
        System.out.println(Arrays.toString(orders));

        orders = new Order[]{
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 200.0),
                new Order(4, "David", 300.0)
        };

        quickSortbooks(orders, 0, orders.length - 1);
        System.out.println("\nbooks after Quick Sort:");
        System.out.println(Arrays.toString(orders));
    }
}
