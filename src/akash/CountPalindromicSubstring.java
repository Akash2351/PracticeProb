package akash;

/**
 * Created by akash on 07-11-2017.
 */
public class CountPalindromicSubstring {

    public static void main(String[] args) {
        CountPalindromicSubstring pal = new CountPalindromicSubstring();
        System.out.println(pal.countSubstrings("abccbad"));
    }

    //same like print all palindromic substring...
    //expand around its centre....
    public int countSubstrings(String s) {
        if (s == null)
            return 0;
        if (s.length() == 1)
            return 1;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendPalindrome(s, i, i);
            count += extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    int extendPalindrome(String s, int left, int right) {
        int len = s.length(), count = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
