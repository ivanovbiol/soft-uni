import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> hiddenMessageList = readStringList();

        System.out.println(findHiddenMessage(hiddenMessageList));
    }

    private static List<String> readStringList() {
        return Arrays
                .stream(new Scanner(System.in).nextLine().split(""))
                .collect(Collectors.toList());
    }

    private static String findHiddenMessage(List<String> hiddenMessageList) {
        List<Integer> numbersList = findNumbersList(hiddenMessageList);
        List<String> nonNumbersList = findNonNumbersList(hiddenMessageList);

        List<Integer> takeList = getTakeIntList(numbersList);
        List<Integer> skipList = getSkipIntList(numbersList);

        StringBuilder stringBuilder = getMessage(nonNumbersList, takeList, skipList);

        return stringBuilder.toString().trim();
    }

    private static List<Integer> findNumbersList(List<String> hiddenMessageList) {
        return hiddenMessageList
                .stream()
                .filter(e -> Character.isDigit(e.charAt(0)))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static List<String> findNonNumbersList(List<String> hiddenMessageList) {
        return hiddenMessageList
                .stream()
                .filter(e -> !Character.isDigit(e.charAt(0)))
                .collect(Collectors.toList());
    }

    private static List<Integer> getTakeIntList(List<Integer> numbersList) {
        List<Integer> takeList = new ArrayList<>();

        for (int index = 0; index < numbersList.size(); index += 2) {
            takeList.add(numbersList.get(index));
        }

        return takeList;
    }

    private static List<Integer> getSkipIntList(List<Integer> numbersList) {
        List<Integer> skipList = new ArrayList<>();

        for (int index = 1; index < numbersList.size(); index += 2) {
            skipList.add(numbersList.get(index));
        }

        return skipList;
    }


    private static StringBuilder getMessage(List<String> nonNumbersList, List<Integer> takeList,
            List<Integer> skipList) {
        StringBuilder stringBuilder = new StringBuilder();

        while (listsContainElements(nonNumbersList, takeList, skipList)) {
            int takeNumberOfElements = takeList.remove(0);
            int skipNumberOfElements = skipList.remove(0);

            if (takeNumberOfElements > nonNumbersList.size()) {
                takeNumberOfElements = nonNumbersList.size();
            }

            stringBuilder.append(
                    String.join("", nonNumbersList.subList(0, takeNumberOfElements)));

            removeElementsFromList(nonNumbersList, takeNumberOfElements);

            if (skipNumberOfElements > nonNumbersList.size()) {
                break;
            }

            removeElementsFromList(nonNumbersList, skipNumberOfElements);
        }
        return stringBuilder;
    }

    private static void removeElementsFromList(List<String> nonNumbersList, int number) {
        while (number-- > 0) {
            nonNumbersList.remove(0);
        }
    }

    private static boolean listsContainElements(List<String> nonNumbersList, List<Integer> takeList,
            List<Integer> skipList) {
        return nonNumbersList.size() != 0 && takeList.size() != 0 && skipList.size() != 0;
    }
}
