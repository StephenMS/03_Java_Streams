import java.io.*;

public class p03CountCharacterTypes {
    public static void main(String[] args) {
        String filePath = "resources/words.txt";

        int vowels = 0;         // a, e, i, o, u
        int consonants = 0;     // all others except:
        int punctuation = 0;    // ! , . ?

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String inputLine = reader.readLine();
            char currentChar = ' ';
            int charASCIIValue = 0;
            while (inputLine != null) {
                // there is avalid value - proceed ...
                for (int i = 0; i < inputLine.length(); i++) {
                    currentChar = inputLine.charAt(i);
                    charASCIIValue = currentChar;
                    if (((charASCIIValue >= 65) && (charASCIIValue <= 90)) ||
                            ((charASCIIValue >= 97) && (charASCIIValue <= 122))) {
                        // currentChar is Letler: [a-z} or [A-Z]
                        if ((charASCIIValue == 65) || (charASCIIValue == 97) ||
                                (charASCIIValue == 69) || (charASCIIValue == 101) ||
                                (charASCIIValue == 73) || (charASCIIValue == 105) ||
                                (charASCIIValue == 79) || (charASCIIValue == 111) ||
                                (charASCIIValue == 85) || (charASCIIValue == 117)) {
                            // there is a vowel:
                            vowels ++;
                        } else {
                            // not a vowel -> consonant
                            consonants ++;
                        }
                    }
                    // the char isn't a letter - lets check for a punctuation mark now ...
                    if ((charASCIIValue == 33) || (charASCIIValue == 44) ||
                            (charASCIIValue == 46) || (charASCIIValue == 63)) {
                        // there is a punctuation mark
                        punctuation ++;
                    }
                }
                inputLine = reader.readLine();
            }
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }


        String savePath = "resources/count-chars.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savePath))) {
            writer.write("Vowels: " + vowels + "\r\n");
            writer.write("Consonants: " + consonants + "\r\n");
            writer.write("Punctuation: " + punctuation + "\r\n");
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
