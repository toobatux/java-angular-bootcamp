import java.util.Scanner;

public class BillSummary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product name: ");
        // TODO: read name
        // String name = _____;
        String name = scanner.nextLine();

        System.out.print("Quantity: ");
        // TODO: read qty (nextLine + Integer.parseInt)
        // int qty = _____;
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Unit price: ");
        // TODO: read price (nextLine + Double.parseDouble)
        // double price = _____;
        double price = Double.parseDouble(scanner.nextLine());

        // TODO: compute total (qty * price), 10% discount, and final amount
        double total = qty * price;
        double discount = total * 0.1;
        double finalAmount = total - discount;

        // TODO: print Product, Quantity, Unit price, Total, Discount (10%), Final amount
        // hints: %.2f for money; use 10%% in the format string to print a literal %
        System.out.printf(
                "Product: %s%n"
                        + "Quantity: %d%n"
                        + "Unit price: $%.2f%n"
                        + "Total: $%.2f%n"
                        + "Discount (10%%): $%.2f%n"
                        + "Final amount: $%.2f%n",
                name, qty, price, total, discount, finalAmount
        );

        scanner.close();
    }
}
