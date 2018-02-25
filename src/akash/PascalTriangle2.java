package akash;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akash on 25-02-2018.
 */
public class PascalTriangle2 {

/*  Given an index k, return the kth row of the Pascal's triangle.
    For example, given k = 3,
    Return [1,3,3,1].
    Note:
    Could you optimize your algorithm to use only O(k) extra space?  */

    public List<Integer> getRow(int rowIndex) {
        //when n==0, list will have 1...1st row
        //this base case is taken care of

        //to store the results of each row
        //and keep using and updating the same for subsequent rows
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        //1st row
        res[0] = 1;

        // coz index will go till j-1...
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) { // traverse from end, not front.
                res[j] += res[j - 1];
            }
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        PascalTriangle2 p2 = new PascalTriangle2();
        System.out.println(p2.getRow(5));
    }
}
