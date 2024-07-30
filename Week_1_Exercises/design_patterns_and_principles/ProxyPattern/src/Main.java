public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("selfimage_1.jpg");
        Image image2 = new ProxyImage("selfimage_2.jpg");

        image1.display();
        System.out.println("");

        image1.display();
        System.out.println("");

        image2.display();
    }
}
