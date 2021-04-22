public class RhombusPrinter {

    // I will change the space sign with a dash (-)
    private static final String SPACE_SIGN = "-";
    private static final String STAR_SIGN = "*";

    private int size;

    public RhombusPrinter(int size) {
        this.setSize(size);
    }

    // Getter
    private int getSize() {
        return this.size;
    }

    // Setter
    private void setSize(int size) {
        if (size > 0) {
            this.size = size;
        }
    }

    public void printRhombus() {
        printUpperPart(this.getSize());
        printLowerPart(this.getSize() - 1);
    }

    private void printUpperPart(int size) {
        for (int iterationIndex = 1; iterationIndex <= size; iterationIndex++) {
            printSpaces(size - iterationIndex);
            printStar(iterationIndex);
            printSpaces(size - iterationIndex);
            System.out.println();
        }
    }

    private void printSpaces(int numberOfCopies) {
        System.out.print(SPACE_SIGN.repeat(numberOfCopies));
    }

    private void printStar(int numberOfCopies) {
        for (int iterationIndex = 1; iterationIndex <= numberOfCopies; iterationIndex++) {
            if (iterationIndex < numberOfCopies) {
                System.out.print(STAR_SIGN);
                System.out.print(SPACE_SIGN);
            } else {
                System.out.print(STAR_SIGN);
            }
        }
    }

    private void printLowerPart(int size) {
        if (size > 0) {
            int spacesCount = 1;
            for (int iterationIndex = size; iterationIndex > 0; iterationIndex--) {
                printSpaces(spacesCount);
                printStar(iterationIndex);
                printSpaces(spacesCount);
                spacesCount++;
                System.out.println();
            }
        }
    }
}
