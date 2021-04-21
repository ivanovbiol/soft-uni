import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private static final String HIGHEST_AVERAGE_SALARY_DEPARTMENT_TEMPLATE = "Highest Average Salary: %s";

    private Department departments;
    private List<Employee> employeeList;

    public Engine() {
        this.setDepartments();
        this.setEmployeeList(new ArrayList<>());
    }

    // Getters
    private Department getDepartments() {
        return this.departments;
    }
    private List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    // Setters
    private void setDepartments() {
        this.departments = new Department();
    }
    private void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] employeeData = readStringArray(scanner);

            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            int age;
            String email;

            if (employeeData.length == 4) {
                this.getEmployeeList().add(new Employee(name, salary, position, department));
                this.getDepartments().add(department, salary);
            } else if (employeeData.length == 5) {
                try {
                    age = Integer.parseInt(employeeData[4]);
                    this.getEmployeeList().add(new Employee(name, salary, position, department, age));
                    this.getDepartments().add(department, salary);
                } catch (NumberFormatException numberFormatException) {
                    email = employeeData[4];
                    this.getEmployeeList().add(new Employee(name, salary, position, department, email));
                    this.getDepartments().add(department, salary);
                }
            } else {
                email = employeeData[4];
                age = Integer.parseInt(employeeData[5]);
                this.getEmployeeList().add(new Employee(name, salary, position, department, email, age));
                this.getDepartments().add(department, salary);
            }
        }

        printSortedEmployees();
    }

    private int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }

    private void printSortedEmployees() {
        System.out.printf(
                HIGHEST_AVERAGE_SALARY_DEPARTMENT_TEMPLATE,
                this.getDepartments().getDepartmentWithHighestSalary())
                .println();

        employeeList
                .stream()
                .filter(e -> e.getDepartment().equals(this.getDepartments().getDepartmentWithHighestSalary()))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::toString)
                .forEach(System.out::println);
    }
}
