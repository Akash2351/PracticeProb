package akash;

/**
 * Created by akash on 03-01-2018.
 */
public class ReverseVowelsOfString {

    public static void main(String[] args) {
        ReverseVowelsOfString rv = new ReverseVowelsOfString();
        System.out.println(rv.reverseVowels("leetcode"));
    }

    /*Write a function that takes a string as input and reverse only the vowels of a string.
    Example 1:
    Given s = "hello", return "holle".
    Example 2:
    Given s = "leetcode", return "leotcede"  */

    public String reverseVowels(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) return str;

        int start = 0, end = str.length() - 1;
        char[] chars = str.toCharArray();
        final String VOWELS = "aeiouAEIOU";

        //use two pointers from both ends...if vowel is found,
        // interchange their values..
        while (start < end) {

            //dont forget start<end condition
            while (start < end && VOWELS.indexOf(chars[start]) == -1)
                start++;
            while (start < end && VOWELS.indexOf(chars[end]) == -1)
                end--;

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}