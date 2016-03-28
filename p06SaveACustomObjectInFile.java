import java.io.*;

public class p06SaveACustomObjectInFile {
    public static void main(String[] args) {
        String pathName = "resources/course.save";
        Course javaDevelop = new Course("Java", 200);
        Course cSharpDevelop = new Course("C#", 150);
        Course assembler = new Course("Assembler", 50);

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(pathName)))) {
            oos.writeObject(javaDevelop);
            oos.writeObject(cSharpDevelop);
            oos.writeObject(assembler);

        } catch (IOException ioex) {
            System.out.println(ioex);
        }


        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(pathName)))) {
            Course courseJava = (Course)ois.readObject();
            System.out.println(courseJava.Name);
            System.out.println(courseJava.StudentsNumber);
            Course courseCSharp = (Course)ois.readObject();
            System.out.println(courseCSharp.Name);
            System.out.println(courseCSharp.StudentsNumber);
            Course courseAssembler = (Course)ois.readObject();
            System.out.println(courseAssembler.Name);
            System.out.println(courseAssembler.StudentsNumber);
        } catch (IOException ioex) {
            System.out.println(ioex);
        } catch (ClassNotFoundException cnfex) {
            System.out.println(cnfex);
        }
    }
}
