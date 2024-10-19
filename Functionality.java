import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Functionality {
    static ConsoleColor color = new ConsoleColor();
    public static Student creatingStudent(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        System.out.println(color.ANSI_GREEN_BACKGROUND + "Please enter student name:" + color.ANSI_RESET);
        student.name = scanner.nextLine();

        System.out.println(color.ANSI_GREEN_BACKGROUND + "Please enter student surname:" + color.ANSI_RESET);
        student.surname = scanner.nextLine();

        System.out.println(color.ANSI_GREEN_BACKGROUND + "Please enter student email:" + color.ANSI_RESET);
        student.email = scanner.nextLine();

        System.out.println(color.ANSI_GREEN_BACKGROUND + "Please enter student group:" + color.ANSI_RESET);
        student.group = scanner.nextLine();

        System.out.printf(color.ANSI_GREEN + "Added student name: %s | surname: %s | email: %s | group: %s %n",student.name,student.surname,student.email,student.group + color.ANSI_RESET);

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

        for (String line: dataFromCsv) {
            if(line.contains(studentName)){
                System.out.printf(color.ANSI_RED + "Removed %s!%n", line + color.ANSI_RESET);
                dataFromCsv.remove(line);
            }

        }

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
        System.out.println(color.ANSI_RED_BACKGROUND + "Write down name to delete:" + color.ANSI_RESET);
        String nameToDelete = scanner.nextLine();
        removingAlgorithm(readingLines(database),nameToDelete);
    }
    public static void printingStudents(List<String> database){

        System.out.println(color.ANSI_YELLOW_BACKGROUND+ database.get(0) + color.ANSI_RESET);
        for (int i = 1; i < database.size(); i++) {
            System.out.println(color.ANSI_YELLOW + database.get(i) + color.ANSI_RESET);
        }
    }
    public void show() throws IOException {
        File database = new File("db.csv");
        printingStudents(readingLines(database));
    }
}
