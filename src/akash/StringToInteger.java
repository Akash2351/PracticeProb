package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 22-02-2018.
 */
public class StringToInteger {

/*The function first discards as many whitespace characters as necessary
    until the first non-whitespace character is found. Then, starting from
    this character, takes an optional initial plus or minus sign followed
    by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the
    integral number, which are ignored and have no effect on the
    behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral
    number, or if no such sequence exists because either str is empty or it contains
    only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
    If the correct value is out of the range of representable values,
    INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.*/

    public static int myAtoi(String str) {
        int ret = 0;
        int sign = 1;
        str = str.trim();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //only + or - can be at the beginning, +-2 is invalid
            if (i == 0 && c == '-') {
                sign = -1;
                list.add(0);
            } else if (i == 0 && c == '+') {
                sign = 1;
                list.add(0);
            }
            //from i=1, numbers should start, else invalid, return 0
            else if (i > 0 && list.size() == 0 && (c < '0' && c > '9')) return 0;
            else if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
            //eliminate the invalid chars at the end..
            else break;
        }

        long mult = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            //traverse from the end..multiple with powers of 10..
            long m = (long) Math.pow(10, mult);
            mult++;

            if (ret + (list.get(i) * m) > Integer.MAX_VALUE) {
                if (sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            ret += list.get(i) * m;
        }
        ret *= sign;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
    }

}
