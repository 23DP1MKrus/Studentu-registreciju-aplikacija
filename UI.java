import java.io.IOException;
import java.util.Scanner;

public class UI {
    ConsoleColor color = new ConsoleColor();
    public void interactionWithUser() throws IOException {
        Functionality student = new Functionality();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the option: to register a new student(register) / to remove an existing student(remove) / to show all students (show)");
        String userInput = scanner.nextLine();
        switch (userInput){
            case("register"):
                student.addToDb(student.creatingStudent());
            case("remove"):
                student.remove();
            case("show"):
                student.show();
            default:
                System.out.println(color.ANSI_RED+" Error: incorrect input" + color.ANSI_RESET);
        }





    }
}
