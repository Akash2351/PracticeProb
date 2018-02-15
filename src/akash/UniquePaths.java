package akash;

/**
 * Created by akash on 14-02-2018.
 */
public class UniquePaths {

/*    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there?  */

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[][] table = new int[m][n];
        int rowLen = table.length, colLen = table[0].length;

        //initialize first row and column to 1's...only 1 way of going
        for (int i = 0; i < rowLen; i++) {
            table[i][0] = 1;
        }
        for (int i = 0; i < colLen; i++) {
            table[0][i] = 1;
        }

        //for any other entry, take the previous top and left  values and add them..
        //this gives all combinations for that particular cell.
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
