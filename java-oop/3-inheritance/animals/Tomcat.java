public class Tomcat extends Cat {

    private static final String MEOW_MESSAGE = "MEOW";
    private static final String MALE_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, MALE_GENDER);
    }

    //Getters
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public String produceSound() {
        return MEOW_MESSAGE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
