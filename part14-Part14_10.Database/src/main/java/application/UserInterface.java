package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            if (command.equals("1")) {
                System.out.println("Listing the database contents");
                System.out.println(database.list());
            } else if (command.equals("2")) {
                System.out.println("Adding a new todo");
                System.out.println("Enter name");
                String name = this.scanner.nextLine();
                System.out.println("Enter description");
                String desq = this.scanner.nextLine();
                Todo fill = new Todo(database.list().size()+1, name, desq, false);
                database.add(fill);
            } else if (command.equals("3")) {
                System.out.println("Which todo should be marked as done (give the id)?");
                int idDone = Integer.valueOf(this.scanner.nextLine());
                database.markAsDone(idDone);
            } else if (command.equals("4")) {
                System.out.println("Which todo should be removed (give the id)?");
                int idRemove = Integer.valueOf(this.scanner.nextLine());
                database.remove(idRemove);
            }
        }

        System.out.println("Thank you!");
    }

}
