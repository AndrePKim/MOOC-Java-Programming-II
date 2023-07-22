
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int row = 0;
        int column = size/2;
        square.placeValue(column, row, 1);
        for (int i=2; i<size*size+1; i++) {
            int nrow = row - 1;
            if (nrow<0) {
                nrow = size-1;
            }
            int ncolumn = column + 1;
            if (ncolumn>=size) {
                ncolumn = 0;
            }
            int read = square.readValue(ncolumn, nrow);
            if (read!=0) {
                nrow = row + 1;
                ncolumn = column;
            }
            square.placeValue(ncolumn, nrow, i);
            row = nrow;
            column = ncolumn;
        }
        return square;
    }

}
