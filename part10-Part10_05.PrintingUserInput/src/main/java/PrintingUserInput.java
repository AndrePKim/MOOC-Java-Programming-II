
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String word = scanner.nextLine();
            if (word.isBlank()) {
                break;
            }
            list.add(word);
        }
        list.stream()
                .forEach(name -> System.out.println(name));

    }
}
