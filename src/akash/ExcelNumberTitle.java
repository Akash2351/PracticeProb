package akash;

/**
 * Created by akash on 20-02-2018.
 */
public class ExcelNumberTitle {


/*  Given a positive integer, return its corresponding column
    title as appear in an Excel sheet.
    For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB*/

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char) ('A' + n % 26)); //range is from 0-25
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}
