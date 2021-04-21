import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final String HIGHEST_AVERAGE_SALARY_PRINT_TEMPLATE = "Highest Average Salary: %s";
    private static String highestSalaryDepartment = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> departmentsSet = new HashSet<>();
        List<Employee> employeeList = readEmployeesList(scanner, departmentsSet);

        printHighestSalaryDepartment(employeeList, departmentsSet);
    }

    private static List<Employee> readEmployeesList(Scanner scanner, Set<String> departmentsSet) {
        List<Employee> employeeList = new ArrayList<>();

        int numberOfLines = readIntNumber(scanner);

        for (int i = 0; i < numberOfLines; i++) {
            String[] employeeData = readSingleLineStringInput(scanner).split("\\s+");

            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email = "";
            int age = 0;

            Employee employee = null;

            if (employeeData.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeData.length == 5) {
                try {
                    age = Integer.parseInt(employeeData[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException numberFormatException) {
                    email = employeeData[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                email = employeeData[4];
                age = Integer.parseInt(employeeData[5]);

                employee = new Employee(name, salary, position, department, email, age);
            }

            employeeList.add(employee);
            departmentsSet.add(department);
        }

        return employeeList;
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readSingleLineStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void printHighestSalaryDepartment(List<Employee> employeeList,
            Set<String> departmentsSet) {
        double highestAverageSalary = 0.0;

        for (String currentDepartment : departmentsSet) {
            double currentAverageSalary =
                    employeeList
                            .stream()
                            .filter(e -> e.getDepartment().equals(currentDepartment))
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .orElse(0);

            if (currentAverageSalary > highestAverageSalary) {
                highestAverageSalary = currentAverageSalary;
                highestSalaryDepartment = currentDepartment;
            }
        }

        System.out.printf(
                HIGHEST_AVERAGE_SALARY_PRINT_TEMPLATE, highestSalaryDepartment)
                .println();

        employeeList
                .stream()
                .filter(e -> e.getDepartment().equals(highestSalaryDepartment))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::toString)
                .forEach(System.out::println);
    }
}
