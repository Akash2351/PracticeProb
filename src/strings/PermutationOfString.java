/**
 * Created by Chiru on Dec 29, 2016
 */
package strings;

public class PermutationOfString {
    public static void main(String[] args) {

        String str = "Chi";
        permutation(str);

    }

    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String remainder = str.substring(0, i) + str.substring(i + 1);
                // System.out.println("str1: " + str.substring(0, i));
                // System.out.println("str2: " + str.substring(i+1));
                permutation(remainder, prefix + str.charAt(i));
            }
        }
    }
}