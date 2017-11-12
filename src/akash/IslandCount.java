package akash;

/**
 * Created by akash on 12-11-2017.
 */
public class IslandCount {

    int rowLen, colLen;

    public int numIslands(char[][] grid) {

        rowLen = grid.length;
        if (rowLen == 0) return 0; //base condition
        colLen = grid[0].length;

        int clusterCount = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    clusterCount++;
                    //make all connected nodes value '0'
                    dfs(grid, i, j);
                }
            }
        }
        return clusterCount;
    }

    void dfs(char[][] grid, int i, int j) {
        //check for boundary conditions and if value is 1.
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] != '1') return;
        // make the value as 0 -> visited node
        grid[i][j] = '0';
        //now check for connected nodes...and make them visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
