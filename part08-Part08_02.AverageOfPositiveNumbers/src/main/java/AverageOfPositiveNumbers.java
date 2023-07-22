
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        int count = 0;
        
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            } else if (number<0) {
                continue;
            }
            sum += number;
            count++;
        }
        if (count>0) {
            System.out.println((double)sum/count);
        } else {
            System.out.println("Cannot calculate the average");
        }

    }
}
