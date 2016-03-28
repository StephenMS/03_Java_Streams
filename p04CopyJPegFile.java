import java.io.*;

public class p04CopyJPegFile {
    public static void main(String[] args) {
        String jpegInputFile = "resources/java_logo.jpg";
        String jpegOutputFile = "resources/my-copied-picture.jpg";

        File inputFile = new File(jpegInputFile);
        File outputFile = new File(jpegOutputFile);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
            InputStream input = new FileInputStream(inputFile);
            byte[] inputBuffer = new byte[fis.available()];     // getting the length of file (in bytes)
            input.read(inputBuffer);

            OutputStream output = new FileOutputStream(outputFile);
            output.write(inputBuffer);


        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
