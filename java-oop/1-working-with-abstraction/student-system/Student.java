public class Student {

    private static final String PRINT_FORMAT_WITH_COMMENTS = "%s is %d years old. %s.";
    private static final String PRINT_FORMAT_WITHOUT_COMMENTS = "%s is %d years old. Very nice person.";
    private static final String EXCELLENT_STRING = "Excellent student";
    private static final String AVERAGE_STRING = "Average student";
    private static final double EXCELLENT_GRADE = 5.5;
    private static final double AVERAGE_GRADE = 4.5;

    private String studentName;
    private int studentAge;
    private double studentGrade;

    public Student(String studentName, int studentAge, double studentGrade) {
        this.setStudentName(studentName);
        this.setStudentAge(studentAge);
        this.setStudentGrade(studentGrade);
    }

    // Getters
    public String getStudentName() {
        return this.studentName;
    }
    private int getStudentAge() {
        return this.studentAge;
    }
    private double getStudentGrade() {
        return this.studentGrade;
    }

    // Setters
    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    private void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
    private void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public String toString() {
        String commentForTheStudent = null;

        if (this.getStudentGrade() >= EXCELLENT_GRADE) {
            commentForTheStudent = EXCELLENT_STRING;
        } else if (this.getStudentGrade() >= AVERAGE_GRADE) {
            commentForTheStudent = AVERAGE_STRING;
        }

        return commentForTheStudent == null ?
                String.format(PRINT_FORMAT_WITHOUT_COMMENTS,
                        this.getStudentName(), this.getStudentAge()) :
                String.format(PRINT_FORMAT_WITH_COMMENTS,
                        this.getStudentName(), this.getStudentAge(), commentForTheStudent);
    }

}
