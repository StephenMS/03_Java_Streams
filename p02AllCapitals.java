import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p02AllCapitals {

    public static List<String> Reader(String filePath) {
        List<String> listItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String inputLine = reader.readLine();
            while (inputLine != null) {
                listItems.add(inputLine);
                inputLine = reader.readLine();
            }
        } catch (FileNotFoundException fnfex) {
            System.out.println(fnfex);
        } catch (IOException ioex) {
            System.out.println(ioex);
        }
        return listItems;
    }

    public static void WriterAllCapitals(String filePath, List<String> inputValues) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String tempString = " ";
            for (String inputValue : inputValues) {
                int lengthLine = inputValue.length();
                tempString = inputValue.toUpperCase() + "\r\n";
                writer.write(tempString);
            }
        } catch (FileNotFoundException fnfex) {
            System.out.println(fnfex);
        } catch (IOException ioex) {
            System.out.println(ioex);
        }
    }


    public static void main(String[] args) {
        String pathOfFile = "resources/lines.txt";
        List<String> stringLines = new ArrayList<>();
        stringLines = Reader(pathOfFile);

        WriterAllCapitals(pathOfFile, stringLines);
    }
}



/*    import java.io.*;

    *//**
 * Created by galeto on 22.03.16.
 *//*
    public class _02_AllCapitals {
        public static void main(String[] args) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("files/lines.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            StringBuilder uppercaseText = new StringBuilder();
            try {
                java.lang.String lines = reader.readLine();
                while (lines != null){
                    uppercaseText.append(lines.toUpperCase() + "\n");
                    lines = reader.readLine();
                }
                try (PrintWriter writer = new PrintWriter(new FileWriter(new File("files/lines.txt")))) {
                    writer.write(uppercaseText.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }*/

