import java.util.Scanner;

public class PersonalDetails {
    public static void main(String[] args) {
        // TODO: Scanner scanner = new Scanner(System.in);
        // TODO: read name (nextLine), age (nextInt), consume leftover newline, city (nextLine)
        // TODO: printf greeting
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your city: ");
        String city = scanner.nextLine();

        System.out.printf("Hello, %s! You are %d years old and live in %s.%n", name, age, city);

        scanner.close();
    }
}
