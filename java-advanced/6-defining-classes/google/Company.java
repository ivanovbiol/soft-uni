public class Company {

    private static final String SALARY_TEMPLATE = "%.2f";
    private static final String SPACE_TEMPLATE = " ";

    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.setName(name);
        this.setDepartment(department);
        this.setSalary(salary);
    }

    //Getters
    private String getName() {
        return this.name;
    }
    private String getDepartment() {
        return this.department;
    }
    private double getSalary() {
        return this.salary;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setDepartment(String department) {
        this.department = department;
    }
    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getName())
                .append(SPACE_TEMPLATE)
                .append(this.getDepartment())
                .append(SPACE_TEMPLATE)
                .append(String.format(SALARY_TEMPLATE, this.getSalary()))
                .append(System.lineSeparator())
                .toString();
    }
}
