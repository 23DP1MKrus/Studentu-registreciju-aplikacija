import java.io.IOException;
import java.util.Scanner;

public class UI {
    ConsoleColor color = new ConsoleColor();
    public void interactionWithUser() throws IOException {
        Functionality student = new Functionality();
        Scanner scanner = new Scanner(System.in);
        while (true) {System.out.println(color.ANSI_WHITE_BACKGROUND + color.ANSI_BLACK + "Please choose the option: to register a new student(register) / to remove an existing student(remove) / to show all students (show) / to exit the program (quit)" + color.ANSI_RESET);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case ("register"):
                    student.addToDb(student.creatingStudent());
                    continue;
                case ("remove"):
                    student.remove();
                    continue;
                case ("show"):
                    student.show();
                    continue;
                case ("quit"):
                    break;
                default:
                    System.out.println(color.ANSI_RED + " Error: incorrect input" + color.ANSI_RESET);

            }
            break;
        }




    }
}
