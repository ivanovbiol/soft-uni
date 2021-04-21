import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final String END_COMMAND = "END";
    private static final String PARTY_COMMAND = "PARTY";

    public static void main(String[] args) {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipInvitationSet = new TreeSet<>();
        Set<String> regularInvitationSet = new TreeSet<>();

        String nextLine = readStringInput(scanner);

        while (!PARTY_COMMAND.equals(nextLine)) {
            String currentGuest = nextLine;

            if (isValidGuest(currentGuest)) {
                if (isGuestVIP(currentGuest)) {
                    vipInvitationSet.add(currentGuest);
                } else {
                    regularInvitationSet.add(currentGuest);
                }
            }

            nextLine = readStringInput(scanner);
        }

        nextLine = readStringInput(scanner);

        while (!END_COMMAND.equals(nextLine)) {
            String currentGuest = nextLine;

            if (isValidGuest(currentGuest)) {
                if (isGuestVIP(currentGuest)) {
                    vipInvitationSet.remove(currentGuest);
                } else {
                    regularInvitationSet.remove(currentGuest);
                }
            }

            nextLine = readStringInput(scanner);
        }

        printMissingGuests(vipInvitationSet, regularInvitationSet);
    }

    private static String readStringInput(Scanner scanner) {
        return scanner.nextLine();
    }

    private static boolean isValidGuest(String currentGuest) {
        return currentGuest.length() == 8;
    }

    private static boolean isGuestVIP(String currentGuest) {
        return Character.isDigit(currentGuest.charAt(0));
    }

    private static void printMissingGuests(Set<String> vipInvitationSet,
            Set<String> regularInvitationSet) {
        System.out.println(vipInvitationSet.size() + regularInvitationSet.size());

        if (!vipInvitationSet.isEmpty()) {
            vipInvitationSet
                    .forEach(System.out::println);
        }

        if (!regularInvitationSet.isEmpty()) {
            regularInvitationSet
                    .forEach(System.out::println);
        }
    }
}