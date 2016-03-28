import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class p07CreateZIPArchive {
    public static void main(String[] args) {
        String filePath1 = "resources/words.txt";
        String filePath2 = "resources/count-chars.txt";
        String filePath3 = "resources/lines.txt";

        String zipFilePath = "resources/text-files.zip";

        try {
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            addToZipFile(filePath1, zos);
            addToZipFile(filePath2, zos);
            addToZipFile(filePath3, zos);

            zos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

        System.out.println("Writing '" + fileName + "' to zip file");

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}

