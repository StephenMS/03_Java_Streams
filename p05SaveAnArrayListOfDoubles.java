import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class p05SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
        String filePath = "resources/doubles.list";
        List<Double> arrayOfDoubles = new ArrayList<>();
        // adding 10 random doubles to the array
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            arrayOfDoubles.add(rand.nextDouble() * 10);
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(filePath)));
            oos.writeObject((Object) arrayOfDoubles);


        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(filePath)));

            System.out.println(" " + ois.readObject());

        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException cnfex) {
            cnfex.printStackTrace();
        }
    }
}
