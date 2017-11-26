package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 25-11-2017.
 */
public class PascalTriangel {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows < 0)
            return list;

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            // j<i+1 , same no of columns as i.. 0 to i
            for (int j = 0; j < i + 1; j++) {
                //add 1 to the first and last column
                if (j == 0 || j == i)
                    row.add(1);
                else {
                    //get previous row values..
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(row);
        }
        return list;
    }
}
