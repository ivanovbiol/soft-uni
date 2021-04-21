public class Employee {

    private static final String EMPTY_STRING_TEMPLATE = "n/a";
    private static final int EMPTY_INT_TEMPLATE = -1;
    private static final String PRINT_TEMPLATE = "%s %.2f %s %d";

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setEmail(EMPTY_STRING_TEMPLATE);
        this.setAge(EMPTY_INT_TEMPLATE);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.setEmail(email);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.setAge(age);
    }

    public Employee(String name, double salary, String position, String department, String email,
            int age) {
        this(name, salary, position, department, email);
        this.setAge(age);
    }

    // Getters
    private String getName() {
        return this.name;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getDepartment() {
        return this.department;
    }
    private String getEmail() {
        return this.email;
    }
    private int getAge() {
        return this.age;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setSalary(double salary) {
        this.salary = salary;
    }
    private void setPosition(String position) {
        this.position = position;
    }
    private void setDepartment(String department) {
        this.department = department;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, this.getName(), this.getSalary(), this.getEmail(),
                this.getAge());
    }
}
