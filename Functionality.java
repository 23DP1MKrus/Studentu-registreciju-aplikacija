import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Functionality {
    public Student creatingStudent(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        student.name = scanner.nextLine();
        student.surname = scanner.nextLine();
        student.email = scanner.nextLine();
        student.group = scanner.nextLine();


        return student;
    }
    public void addToDb(Student newStudent) throws IOException {
        ArrayList<String> studentData = new ArrayList<>();
        studentData.add(newStudent.name);
        studentData.add(newStudent.surname);
        studentData.add(newStudent.email);
        studentData.add(newStudent.group);

        FileWriter writer = new FileWriter("db.csv",true);
        writer.append("NAME | ");
        writer.append("SURNAME | ");
        writer.append("EMAIL | ");
        writer.append("GROUP | ");
        writer.append("\n");
        for (String studentRow: studentData) {
            writer.append(String.join(" | ",studentRow));
            writer.append(" | ");

        }
        writer.flush();
        writer.close();
    }
}
