package akash;

/**
 * Created by akash on 14-11-2017.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix pre = new LongestCommonPrefix();
        System.out.println(pre.longestCommonPrefix(new String[]{"hello", "helli"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int maxlen = Integer.MAX_VALUE;
        String min = null;
        //find the length of shortest string..
        // the answer cannot be longer than this.
        for (String str : strs) {
            if (str.length() < maxlen) {
                maxlen = str.length();
                min = str;
            }
        }
        //for 0 to maxlen,
        //check if char[i] is same for all strings,
        //else stop and return till last i;
        boolean end = false;
        for (int i = 0; i < maxlen; i++) {
            for (String str : strs) {
                if (min.charAt(i) != str.charAt(i)) {
                    end = true;
                    break;
                }
            }
            if (end) {
                if (i == 0) return "";
                else
                    return min.substring(0, i);
            }
        }
        return min;
    }
}
