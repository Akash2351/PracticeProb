package akash;

/**
 * Created by akash on 03-11-2017.
 */
public class MatrixRotation {

    /*The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
        1  2  3
        4  5  6
        7  8  9
    after transpose, it will be swap(matrix[i][j], matrix[j][i])
        1  4  7
        2  5  8
        3  6  9
    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
        7  4  1
        8  5  2
        9  6  3*/

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // first transpose the matrix...
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //flip the elements in same row...around its centre...Reverse.
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
