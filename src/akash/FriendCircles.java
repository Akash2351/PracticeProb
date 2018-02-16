package akash;

/**
 * Created by akash on 15-02-2018.
 */
public class FriendCircles {

/*There are N students in a class. Some of them are friends, while some are not.
    Their friendship is transitive in nature. For example, if A is a direct
    friend of B, and B is a direct friend of C, then A is an indirect friend of C.
    And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class.
    If M[i][j] = 1, then the ith and jth students are direct friends with each other,
    otherwise not. And you have to output the total number of friend
    circles among all the students.

   Input:
   [[1,1,0],
   [1,1,0],
   [0,0,1]]
    Output: 2  */

    public int findCircleNum(int[][] M) {
        int circleCount = 0;
        int rowLen = M.length;

        //same like island count...use dfs to recursively find friends
        // and make their entry 0.
        for (int i = 0; i < rowLen; i++)
            for (int j = 0; j < rowLen; j++) {
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    circleCount++;
                }
            }

        return circleCount;
    }

    public void dfs(int[][] M, int i, int j) {
        if (M[i][j] == 0) return;
        M[i][j] = 0;

        //make all friends of i and j 0's recursively
        for (int k = 0; k < M.length; k++) {
            if (M[i][k] == 1) dfs(M, i, k);
            if (M[k][i] == 1) dfs(M, k, i);
            if (M[j][k] == 1) dfs(M, j, k);
            if (M[k][j] == 1) dfs(M, k, j);
        }
    }
}
