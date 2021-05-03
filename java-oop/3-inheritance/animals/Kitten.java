public class Kitten extends Cat {

    private static final String MEOW_MESSAGE = "Meow";
    private static final String FEMALE_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, FEMALE_GENDER);
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
