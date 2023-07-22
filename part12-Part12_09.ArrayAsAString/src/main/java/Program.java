
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
    }
    
    public static String arrayAsString(int[][] array) {
        StringBuilder numbers = new StringBuilder();
        String row = "";
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                numbers.append(array[i][j]);
            }
            numbers.append(row+"\n");
            row = "";
        }
        return numbers.toString();
    }

}
