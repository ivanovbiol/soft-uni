import java.util.LinkedList;
import java.util.List;

public class Trainer {

    private static final int INITIAL_NUMBER_OF_BADGES = 0;
    private static final String PRINT_FORMAT = "%s %d %d";

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.setName(name);
        this.setNumberOfBadges(INITIAL_NUMBER_OF_BADGES);
        this.setPokemonList(new LinkedList<>());
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }
    private List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }
    private void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        this.getPokemonList().add(pokemon);
    }

    public void checkForPokemonWithCurrentElement(String element) {
        if (this.getPokemonList()
                .stream()
                .anyMatch(pokemon -> pokemon.getElement().equals(element))) {
            this.setNumberOfBadges(this.getNumberOfBadges() + 1);
        } else {
            this.getPokemonList()
                    .forEach(Pokemon::decreaseHealth);
        }
    }

    @Override
    public String toString() {
        int numberOfLifePokemons =
                (int) this.getPokemonList()
                        .stream()
                        .filter(pokemon -> !pokemon.getIsDead())
                        .count();

        return String.format(
                PRINT_FORMAT, this.getName(), this.getNumberOfBadges(), numberOfLifePokemons);
    }
}
