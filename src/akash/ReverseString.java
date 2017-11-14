package akash;

/**
 * Created by akash on 14-11-2017.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() == 1)
            return s;

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = chars.length;

        for (int i = len - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
