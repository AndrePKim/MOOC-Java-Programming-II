
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(value -> value.split(","))
                    .filter(parts -> parts.length >= 2)
                    .sorted((p1,p2) -> {
                        return p1[5].compareTo(p2[5]);
                    })
                    .forEach(value -> System.out.println(value[3] 
                            + " (" + value[4] + "), " 
                            + value[2].trim().substring(0,value[2].length()-5) 
                            + ", " + value[5]));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
