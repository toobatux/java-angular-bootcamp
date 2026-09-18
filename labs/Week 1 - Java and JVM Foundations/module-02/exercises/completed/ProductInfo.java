import java.util.Scanner;

public class ProductInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: read name (String), quantity (int via parse), price (double via parse)
        // TODO: print labeled summary
        System.out.println("Product name: ");
        String name = scanner.nextLine();

        System.out.println("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.println("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.printf("Product: %s | Qty: %d | Price: %.2f%n", name, qty, price);

        scanner.close();
    }
}
