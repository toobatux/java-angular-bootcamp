import java.util.List;

public class RaiseDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // TODO: map each salary * 1.10 without mutating source employees
        List<Double> raised = employees.stream()
                // TODO: .map(...)
                // TODO: .toList()
                .map(employee -> employee.salary() * 1.10)
                .toList()
                ;

//        System.out.println("Raised salaries:");
//        raised.forEach(s -> System.out.printf("%.0f%n", s));

        System.out.println("Proposed salaries:");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            double proposed = raised.get(i);
            System.out.printf("%s: %.2f -> %.2f%n",
                    employee.name(), employee.salary(), proposed);
        }

        System.out.println("Original Alice salary: " + employees.get(0).salary());
    }
}
