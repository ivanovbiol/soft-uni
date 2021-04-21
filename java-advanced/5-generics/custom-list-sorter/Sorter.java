public class Sorter<T extends Comparable<T>> {

    public static void sort(CustomList customList) {
        for (int index = 0; index < customList.size(); index++) {
            String element = (String) customList.getElementAtIndex(index);

            for (int innerIndex = index + 1; innerIndex < customList.size(); innerIndex++) {
                String nextElement = (String) customList.getElementAtIndex(innerIndex);
                if (element.compareTo(nextElement) > 0) {
                    customList.swap(index, innerIndex);
                }
            }

        }
    }
}
