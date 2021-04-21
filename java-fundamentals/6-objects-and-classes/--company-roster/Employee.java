public class Employee {

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
        this.setEmail("n/a");
        this.setAge(-1);
    }

    public Employee(String name, double salary, String position, String department,
            int age) {
        this(name, salary, position, department);
        this.setAge(age);
    }

    public Employee(String name, double salary, String position, String department,
            String email) {
        this(name, salary, position, department);
        this.setEmail(email);
    }

    public Employee(String name, double salary, String position, String department,
            String email, int age) {
        this(name, salary, position, department, email);
        this.setAge(age);
    }

    private String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    private String getEmail() {
        return email;
    }

    private int getAge() {
        return age;
    }

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
        return String
                .format("%s %.2f %s %d",
                        this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
