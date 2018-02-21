package akash;

/**
 * Created by akash on 20-02-2018.
 */
public class ExcelColumnNumber {

/*Given a column title as appear in an Excel sheet, return its
    corresponding column number.
    For example:
    A -> 1
    B -> 2
            ...
    Z -> 26
    AA -> 27
    AB -> 28*/

    public int titleToNumber(String s) {
        //AB case
        // 1*26 + 1+ 1 = 28

        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            col = col * 26 + (s.charAt(i) - 'A') + 1;
        }
        return col;
    }
}
