import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Department {

    private Map<String, Double> departmentsAndTotalSalaries;

    public Department() {
        this.departmentsAndTotalSalaries = new HashMap<>();
    }

    // Getter
    private Map<String, Double> getDepartmentsAndTotalSalaries() {
        return this.departmentsAndTotalSalaries;
    }

    public void add(String department, double salary) {
        this.getDepartmentsAndTotalSalaries().putIfAbsent(department, 0.0);
        double newSalary = this.getDepartmentsAndTotalSalaries().get(department) + salary;
        this.getDepartmentsAndTotalSalaries().put(department, newSalary);
    }

    public String getDepartmentWithHighestSalary() {
        return this.getDepartmentsAndTotalSalaries()
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Entry::getValue))
                .map(Entry::getKey)
                .get();
    }
}
