import java.util.Arrays;

public class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Linear search method using traditional for loop
    public static Book linearSearch(Book[] books, String bookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].bookId.equals(bookId)) {
                return books[i];
            }
        }
        return null; // Book not found
    }

    // Binary search method
    public static Book binarySearch(Book[] books, String bookId) {
        
        Arrays.sort(books, (p1, p2) -> p1.bookId.compareTo(p2.bookId));

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midProductId = books[mid].bookId;

            if (midProductId.equals(bookId)) {
                return books[mid];
            } else if (midProductId.compareTo(bookId) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Book not found
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create sample books
        Book p1 = new Book("002", "The Alchemist", "Paulo Coelho");
        Book p2 = new Book("001", "Gone with the Wind", "Margaret Mitchell");
        Book p3 = new Book("003", "Ikigai", "Hector Garcia");

        // Store books in an array
        Book[] books = { p1, p2, p3 };

        // Perform linear search
        Book resultLinear = linearSearch(books, "001");
        System.out.println("Linear Search Result: " + (resultLinear != null ? 
            "Book ID: " + resultLinear.bookId + 
            ", Name: " + resultLinear.title + 
            ", Category: " + resultLinear.author : 
            "Book not found"));

        // Perform binary search
        Book resultBinary = binarySearch(books, "003");
        System.out.println("Binary Search Result: " + (resultBinary != null ? 
            "Book ID: " + resultBinary.bookId + 
            ", Name: " + resultBinary.title + 
            ", Category: " + resultBinary.author : 
            "Book not found"));
    }
}
