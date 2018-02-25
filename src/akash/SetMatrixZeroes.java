package akash;

/**
 * Created by akash on 24-02-2018.
 */
public class SetMatrixZeroes {

/*Given a m x n matrix, if an element is 0, set its entire row
    and column to 0. Do it in place.*/

    public void setZeroes(int[][] matrix) {

        //One solution would be store the indices where rows are 0
        // and columns are 0. it would take int[m], int[n] additional space.
        // this would be O(m+n)

        //better solution would be to use the first row and column
        // of the given matrix to store this values.
        // the value for first row and col can be stored in two flags.
        // so a constant space would be required...   O(1)

        boolean rowZero = false;
        boolean colZero = false;
        int rowLen = matrix.length, colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) {
            if (matrix[i][0] == 0) colZero = true;
        }
        for (int i = 0; i < colLen; i++) {
            if (matrix[0][i] == 0) rowZero = true;
        }

        //set corresponding enteries in row[o] or col[0]..
        //and track later and make entire row/ column 0's
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //make the entire row/col 0's
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //make first row zeros..
        if (rowZero) {
            for (int i = 0; i < colLen; i++)
                matrix[0][i] = 0;
        }
        //make first col zeros.
        if (colZero) {
            for (int i = 0; i < rowLen; i++)
                matrix[i][0] = 0;
        }
    }
}
