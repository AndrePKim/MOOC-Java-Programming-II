
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("end")) {
                break;
            }
            list.add(answer);
        }
        double average = list.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        
        
        System.out.println("average of the numbers: " + average);
        
    }
}
