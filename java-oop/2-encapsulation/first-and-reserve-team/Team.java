import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private static final int AGE_THRESHOLD = 40;

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.setName(name);
        this.setFirstTeam(new ArrayList<>());
        this.setReserveTeam(new ArrayList<>());
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setFirstTeam(List<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }
    private void setReserveTeam(List<Person> secondTeam) {
        this.reserveTeam = secondTeam;
    }

    public void addPlayer(Person person) {
        if (person.getAge() < AGE_THRESHOLD) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }
}
