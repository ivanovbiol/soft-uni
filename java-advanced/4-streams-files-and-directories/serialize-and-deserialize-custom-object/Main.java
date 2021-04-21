import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.InvalidPathException;

public class Main {

    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube (String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public String getColor() {
            return  this.color;
        }

        public double getWidth() {
            return  this.width;
        }

        public double getHeight() {
            return  this.height;
        }

        public double getDepth() {
            return  this.depth;
        }
    }

    public static void main(String[] args) throws InvalidPathException {
        readInputAndPrintResult();
    }

    private static void readInputAndPrintResult() throws InvalidPathException {
        // The file path should be customised from every user of the program
        // depending on the file location
        String pathName = "C:\\serializedObject.txt";

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathName));
            Cube currentCube = new Cube("green", 15.3, 12.4, 3.0);
            objectOutputStream.writeObject(currentCube);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
            Cube deserializedCube = (Cube) objectInputStream.readObject();

            System.out.println(deserializedCube.getColor());
            System.out.println(deserializedCube.getWidth());
            System.out.println(deserializedCube.getHeight());
            System.out.println(deserializedCube.getDepth());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}