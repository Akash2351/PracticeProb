/**
 * Created by Chiru on Jan 9, 2017
 */
package strings;

// Reversing the string:
// input: "problem. good a is This"
// output: "This is a good problem."
public class ReverseSentence {

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("problem. good a is This");
        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str = stringRevIndexed(str, startIndex, i - 1);
                startIndex = i + 1;
            }
        }
        // reverse the last word
        str = stringRevIndexed(str, startIndex, str.length() - 1);
        // reverse the whole string now
        str = stringRevIndexed(str, 0, str.length() - 1);

        System.out.println(str);
    }

    static StringBuffer stringRevIndexed(StringBuffer str, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            char temp = str.charAt(startIndex);

            str.setCharAt(startIndex, str.charAt(endIndex));
            str.setCharAt(endIndex, temp);
            startIndex++;
            endIndex--;
        }
        return str;
    }
}