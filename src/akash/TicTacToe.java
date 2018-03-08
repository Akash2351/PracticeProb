package akash;

import java.util.Arrays;

/**
 * Created by akash on 07-03-2018.
 */
public class TicTacToe {

/* Design a Tic-tac-toe game that is played between two players on a n x n grid.
You may assume the following rules:
 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal,
  vertical, or diagonal row wins the game.
 */

    //O(N) approach...check that particular row/col
    // and diagonal to see if they are the same...O(n)

    int n;
    int[][] table;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        table = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(table[i], -1);
        //assuming player 1 -> 0, player 2 ->1
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int mark = 0;
        if (player == 2)
            mark = 1;
        table[row][col] = mark;

        int winner = -1;

        int rw = checkRow(row);
        if (rw != -1) {
            return rw == 0 ? 1 : 2;
        }
        int cl = checkCol(col);
        if (cl != -1) {
            return cl == 0 ? 1 : 2;
        }


        winner = checkDiagonal1();
        if (winner != -1) {
            return winner == 0 ? 1 : 2;
        }
        winner = checkDiagonal2();
        if (winner != -1) {
            return winner == 0 ? 1 : 2;
        }

        return 0;
    }

    //return -1 if not same, if same, returns the value.
    public int checkRow(int row) {
        int val = table[row][0];
        for (int i = 1; i < n; i++) {
            if (table[row][i] == val) continue;
            return -1;
        }
        return val;
    }

    //return -1 if not same, if same, returns the value.
    public int checkCol(int col) {
        int val = table[0][col];
        for (int i = 1; i < n; i++) {
            if (table[i][col] == val) continue;
            return -1;
        }
        return val;
    }

    public int checkDiagonal1() {
        int val = table[0][0];
        for (int i = 1; i < n; i++) {
            if (table[i][i] != val) return -1;
        }
        return val;
    }

    public int checkDiagonal2() {
        int val = table[0][n - 1];
        for (int i = 1; i < n; i++) {
            if (table[i][n - 1 - i] != val) return -1;
        }
        return val;
    }

    /*O(1) approach:
    * The key observation is that in order to win Tic-Tac-Toe you must
    * have the entire row or column. Thus, we don’t need to keep track
    * of an entire n^2 board. We only need to keep a count for each row and column.
     * If at any time a row or column matches the size of the board
     * then that player has won.*/
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public int move2(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }

        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) {
            return player;
        }

        return 0;
    }
}
