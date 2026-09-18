import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentCountDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.sample();

        // TODO: groupingBy department + counting
        Map<String, Long> counts = employees.stream()
                // TODO: .collect(Collectors.groupingBy(...))
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

        counts.forEach((dept, count) ->
                System.out.println(dept + ": " + count));
    }
}
