package akash;

/**
 * Created by akash on 03-01-2018.
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int col = grid[0].length;
        int row = grid.length;
        int per = 0;

        //check for the corner islands, no surrounding islands,
        // then add 1 to perimeter
        // do this for all the islands...
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) per++;
                    if (i == row - 1 || grid[i + 1][j] == 0) per++;
                    if (j == 0 || grid[i][j - 1] == 0) per++;
                    if (j == col - 1 || grid[i][j + 1] == 0) per++;
                }
            }
        }
        return per;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]
                {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}};
        IslandPerimeter ip = new IslandPerimeter();
        System.out.println(ip.islandPerimeter(grid));
    }
}
