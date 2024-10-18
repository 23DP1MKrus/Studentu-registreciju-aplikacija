import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Functionality {
    public static Student creatingStudent(){
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
        try{
            startCsvFile();
            writer.append("\n");
            for (String studentRow: studentData) {
                writer.append(String.join(" | ",studentRow));
                writer.append(" | ");

            }
            writer.flush();
            writer.close();
        }
        catch (IndexOutOfBoundsException e){
            writer.append("NAME | ");
            writer.append("SURNAME | ");
            writer.append("EMAIL | ");
            writer.append("GROUP | ");
            writer.append("\n");

            for (String studentRow: studentData) {
                writer.append(String.join(" | ",studentRow));
                writer.append(" | ");

            }
            writer.append("\n");
            writer.flush();
            writer.close();
        }

    }
    public static List<String> readingLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line = null;
        while((line = reader.readLine()) != null){
            lines.add(line);
        }


        return lines;
    }
    public static void startCsvFile() throws IOException {
        FileWriter writer = new FileWriter("db.csv",true);
        File database = new File("db.csv");
        String firstLine = readingLines(database).get(0);
        if(!firstLine.equals("NAME | SURNAME | EMAIL | GROUP |".trim())){
            writer.append("NAME | ");
            writer.append("SURNAME | ");
            writer.append("EMAIL | ");
            writer.append("GROUP | ");
            writer.append("\n");
        }
    }

    public static void removingAlgorithm(List<String> dataFromCsv, String studentName) throws IOException {
        dataFromCsv.removeIf(line -> line.contains(studentName));
        dataFromCsv.removeAll(Arrays.asList("",null));
        FileWriter writer = new FileWriter("db.csv",false);
        for (String line: dataFromCsv) {
            writer.append(line);
            writer.append("\n");
            }

        writer.flush();
        writer.close();

    }
    public void remove() throws IOException {
        File database = new File("db.csv");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write down name to delete:");
        String nameToDelete = scanner.nextLine();
        removingAlgorithm(readingLines(database),nameToDelete);
    }
    public static void printingStudents(List<String> database){
        for (String line: database) {
            System.out.println(line);
        }
    }
    public void show() throws IOException {
        File database = new File("db.csv");
        printingStudents(readingLines(database));
    }
}
