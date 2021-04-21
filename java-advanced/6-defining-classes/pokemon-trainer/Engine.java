import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private static final String TOURNAMENT_COMMAND = "Tournament";
    private static final String END_COMMAND = "End";

    private List<Trainer> trainersList;

    public Engine() {
        this.setTrainersList(new LinkedList<>());
    }

    // Getter
    private List<Trainer> getTrainersList() {
        return this.trainersList;
    }

    //Setter
    private void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        String input = readStringLine(scanner);

        while (!input.equals(TOURNAMENT_COMMAND)) {
            String[] trainersInfo = input.split("\\s+");

            String trainerName = trainersInfo[0];
            String pokemonName = trainersInfo[1];
            String pokemonElement = trainersInfo[2];
            int pokemonHealth = Integer.parseInt(trainersInfo[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainerDoesNotExist(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                this.addTrainerToList(trainer);
            } else {
                this.getTrainersList()
                        .stream()
                        .filter(trainer -> trainer.getName().equals(trainerName))
                        .findFirst()
                        .ifPresent(trainer -> trainer.addPokemon(pokemon));
            }

            input = readStringLine(scanner);
        }

        String queryElement = readStringLine(scanner);

        while (!queryElement.equals(END_COMMAND)) {
            checkForPokemonWithCurrentElement(queryElement);

            queryElement = readStringLine(scanner);
        }

        printTrainers();
    }

    private String readStringLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private boolean trainerDoesNotExist(String trainerName) {
        return this.getTrainersList()
                .stream()
                .noneMatch(trainer -> trainer.getName().equals(trainerName));
    }

    private void addTrainerToList(Trainer trainer) {
        this.getTrainersList().add(trainer);
    }

    private void checkForPokemonWithCurrentElement(String queryElement) {
        this.getTrainersList()
                .forEach(trainer -> trainer.checkForPokemonWithCurrentElement(queryElement));
    }

    private void printTrainers() {
        this.getTrainersList()
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}
