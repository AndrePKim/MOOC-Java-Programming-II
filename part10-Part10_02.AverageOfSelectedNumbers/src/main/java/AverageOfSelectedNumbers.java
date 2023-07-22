
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("end")) {
                break;
            }
            list.add(answer);
        }
        double paverage = list.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> number>=0)
                .average()
                .getAsDouble();
        double naverage = list.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> number<0)
                .average()
                .getAsDouble();
        System.out.println("\nPrint the average of the negative numbers or the positive numbers? (n/p)");
        String answer = scanner.nextLine();
        if (answer.equals("n")) {
            System.out.println("Average of the negative numbers: " + naverage);
        } else if (answer.equals("p")) {
            System.out.println("Average of the positive numbers; " + paverage);
        }

    }
}
