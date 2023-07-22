
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String num = scanner.nextLine();
            if (Integer.valueOf(num)<0) {
                break;
            }
            list.add(num);
        }
        list.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> number<=5 && number>=1)
                .forEach(number -> System.out.println(number));
    }
}
