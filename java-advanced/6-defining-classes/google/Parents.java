public class Parents {

    private static final String SPACE_TEMPLATE = " ";

    private String name;
    private String birthdayDate;

    public Parents(String name, String birthdayDate) {
        this.setName(name);
        this.setBirthdayDate(birthdayDate);
    }

    //Getters
    private String getName() {
        return this.name;
    }
    private String getBirthdayDate() {
        return this.birthdayDate;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getName())
                .append(SPACE_TEMPLATE)
                .append(this.getBirthdayDate())
                .append(System.lineSeparator())
                .toString();
    }
}
