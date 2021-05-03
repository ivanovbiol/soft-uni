public class Frog extends Animal {

    private static final String RIBBIT_MESSAGE = "Ribbit";

    public Frog(String name, int age, String gender) {
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
        return RIBBIT_MESSAGE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
