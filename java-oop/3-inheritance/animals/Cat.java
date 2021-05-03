public class Cat extends Animal {

    private static final String MEOW_MEOW_MESSAGE = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
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
        return MEOW_MEOW_MESSAGE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
