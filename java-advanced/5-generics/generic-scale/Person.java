public class Person implements Comparable<Person> {

    private String name;
    private double weight;

    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        return Double.compare(this.weight, person.weight);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
