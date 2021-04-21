import java.util.ArrayList;
import java.util.List;

public class Person {

    private static final String COLON_TEMPLATE = ":";

    private String name;
    private Company company;
    private List<Pokemon> pokemonsList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person(String name) {
        this.setName(name);
        this.setCompany(null);
        this.setPokemonList(new ArrayList<>());
        this.setParentsList(new ArrayList<>());
        this.setChildrenList(new ArrayList<>());
        this.setCar(null);
    }

    // Getters
    private String getName() {
        return this.name;
    }
    private Company getCompany() {
        return this.company;
    }
    private List<Pokemon> getPokemonsList() {
        return this.pokemonsList;
    }
    private List<Parents> getParentsList() {
        return this.parentsList;
    }
    private List<Children> getChildrenList() {
        return this.childrenList;
    }
    private Car getCar() {
        return this.car;
    }

    // Setters
    private void setName(String name) {
        this.name = name;
    }
    private void setCompany(Company company) {
        this.company = company;
    }
    private void setPokemonList(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }
    private void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }
    private void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }
    private void setCar(Car car) {
        this.car = car;
    }

    public void addCompany(Company company) {
        this.setCompany(company);
    }

    public void addPokemon(Pokemon pokemon) {
        this.getPokemonsList().add(pokemon);
    }

    public void addParent(Parents parent) {
        this.getParentsList().add(parent);
    }

    public void addChild(Children child) {
        this.getChildrenList().add(child);
    }

    public void addCar(Car car) {
        this.setCar(car);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(this.getName()).append(System.lineSeparator());

        stringBuilder
                .append(Company.class.getName())
                .append(COLON_TEMPLATE)
                .append(System.lineSeparator());
        if (this.getCompany() != null) {
            stringBuilder
                    .append(this.getCompany().toString());
        }

        stringBuilder
                .append(Car.class.getName())
                .append(COLON_TEMPLATE)
                .append(System.lineSeparator());
        if (this.getCar() != null) {
            stringBuilder
                    .append(this.getCar().toString());
        }

        stringBuilder
                .append(Pokemon.class.getName())
                .append(COLON_TEMPLATE)
                .append(System.lineSeparator());
        if (!this.getPokemonsList().isEmpty()) {
            stringBuilder.append(getPokemonsAsString());
        }

        stringBuilder
                .append(Parents.class.getName())
                .append(COLON_TEMPLATE)
                .append(System.lineSeparator());
        if (!this.getParentsList().isEmpty()) {
            stringBuilder.append(getParentAsString());
        }

        stringBuilder
                .append(Children.class.getName())
                .append(COLON_TEMPLATE)
                .append(System.lineSeparator());
        if (!this.getChildrenList().isEmpty()) {
            stringBuilder.append(getChildrenAsString());
        }

        return stringBuilder.toString().trim();
    }

    private String getPokemonsAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        this.getPokemonsList()
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private String getParentAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        this.getParentsList()
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private String getChildrenAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        this.getChildrenList()
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
