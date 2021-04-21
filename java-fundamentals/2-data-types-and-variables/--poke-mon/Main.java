import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pokemonPower = readInteger(scanner);
        int distance = readInteger(scanner);
        int exhaustionFactor = readInteger(scanner);

        System.out.println(getResult(pokemonPower, distance, exhaustionFactor));

    }

    private static int readInteger(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine());

    }

    private static String getResult(int pokemonPower, int distance, int exhaustionFactor) {

        int counter = 0;
        int halfPokemonPower = 0;

        if (pokemonPower % 2 == 0) {
            halfPokemonPower = pokemonPower / 2;
        }

        while (pokemonPower >= distance) {

            if (pokemonPower == halfPokemonPower && exhaustionFactor != 0) {
                pokemonPower /= exhaustionFactor;
            }

            if (pokemonPower < distance) {
                break;
            }

            pokemonPower -= distance;

            counter++;

        }

        return pokemonPower + System.lineSeparator() + counter;

    }
}