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

}
