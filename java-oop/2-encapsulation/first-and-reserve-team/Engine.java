import java.util.Scanner;

public class Engine {

    private static final String DELIMITER = "\\s+";
    private static final String FIRST_TEAM_PRINT_TEMPLATE = "First team have %d players";
    private static final String REVERSE_TEAM_PRINT_TEMPLATE = "Reserve team have %d players";
    private static final String TEAM_NAME = "BLACK EAGLES";

    private Team team;

    public Engine() {
        this.setTeam(new Team(TEAM_NAME));
    }

    // Getter
    private Team getTeam() {
        return this.team;
    }

    // Setter
    private void setTeam(Team team) {
        this.team = team;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = readIntNumber(scanner);

        while (numberOfLines-- > 0) {
            String[] personInfo = readStringArray(scanner);

            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            double salary = Double.parseDouble(personInfo[3]);

            try {
                Person person = new Person(firstName, lastName, age, salary);
                this.getTeam().addPlayer(person);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }

        printTeamSizes();
    }

    private static int readIntNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(DELIMITER);
    }

    private void printTeamSizes() {
        System.out.printf(FIRST_TEAM_PRINT_TEMPLATE, this.team.getFirstTeam().size()).println();
        System.out.printf(REVERSE_TEAM_PRINT_TEMPLATE, this.team.getReserveTeam().size()).println();
    }
}