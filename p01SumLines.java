import java.io.*;

/**
 * Created by stoya on 27.3.2016 г..
 */
public class p01SumLines {

    private static final String FILE_PATH = "resources/lines.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String inputLine = reader.readLine();
            while (inputLine != null) {
                int sum = 0;    // sum of char's ascii values
                char curentChar = ' ';
                for (int i = 0; i < inputLine.length(); i++) {
                    curentChar = inputLine.charAt(i);
                    sum += curentChar;
                }
                System.out.println(sum);
                sum = 0;

                inputLine = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
