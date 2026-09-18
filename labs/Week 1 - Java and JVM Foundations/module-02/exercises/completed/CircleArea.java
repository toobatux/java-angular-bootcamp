import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: read radius as double
        System.out.println("Radius: ");
        // TODO: area = Math.PI * r * r; printf with decimals
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * r * r;
        System.out.printf("Radius: %.2f%n", r);
        System.out.printf("Area: %.2f%n", area);
    }
}
