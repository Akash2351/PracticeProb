package akash;

/**
 * Created by akash on 04-03-2018.
 */
public class ReverseWordsInPlace {

/* Given an input string, reverse the string word by word.
 A word is defined as a sequence of non-space characters.

    The input string does not contain leading or trailing
    spaces and the words are always separated by a single space.

    For example,
    Given s = "the sky is blue",
     return "blue is sky the".

    Could you do it in-place without allocating extra space?*/

    public void reverseWords(char[] str) {
        //reverse entire string first...
        reverse(str, 0, str.length - 1);

        //reverse each word..
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        //last word will not be reversed...reverse it
        reverse(str, start, str.length - 1);

    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
