package akash;

/**
 * Created by akash on 02-03-2018.
 */
public class MinimumPathSum {

/* Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the
sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

            Example 1:
            [[1,3,1],
            [1,5,1],
            [4,2,1]]
    Given the above grid map, return 7. Because the
    path 1→3→1→1→1 minimizes the sum.*/

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;

        //initialize first row n column..
        //first row, add the previous col to curr value
        for (int i = 1; i < rowLen; i++)
            grid[i][0] += grid[i - 1][0];

        //first col, add previous row to val...
        for (int i = 1; i < colLen; i++)
            grid[0][i] += grid[0][i - 1];

        //for cell[i][j], take min of left or top value...
        for (int i = 1; i < rowLen; i++)
            for (int j = 1; j < colLen; j++) {
                grid[i][j] += Integer.min(grid[i - 1][j], grid[i][j - 1]);
            }

        return grid[rowLen - 1][colLen - 1];
    }
}
