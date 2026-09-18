import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First number: ");
        // TODO: double a = Double.parseDouble(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Second number: ");
        // TODO: double b = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.next());

        // TODO: printf Sum, Difference, Product, Quotient with %.2f
        double sum = a + b;
        double difference = a - b;
        double product = a * b;
        double quotient = a / b;

        System.out.printf("Sum: %.2f%n", sum);
        System.out.printf("Difference: %.2f%n", difference);
        System.out.printf("Product: %.2f%n", product);
        System.out.printf("Quotient: %.2f%n", quotient);
    }
}
