package akash;

import java.util.Stack;

/**
 * Created by akash on 31-03-2018.
 */
public class DecodeString {

/*Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".*/

    public String decodeString(String s) {
        if (s.isEmpty() || s.length() == 1) return s;

        Stack<Integer> noStk = new Stack<>();
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while ((c = s.charAt(i + 1)) >= '0' && c <= '9') {
                    sb.append(c);
                    i++;
                }
                noStk.push(Integer.valueOf(sb.toString()));
                continue;
            }

            if (c == '[') {
                stk.push(c + "");
                continue;
            }
            if (c == ']') {
                String top = stk.pop();
                top = top.substring(1);
                String cur = "";
                int count = noStk.pop();
                for (int j = 0; j < count; j++) {
                    cur += top;
                }
                String last = "";
                if (stk.size() != 0) {
                    last = stk.pop();
                }
                stk.push(last + cur);
            } else {
                if (stk.isEmpty()) {
                    stk.push(c + "");
                } else {
                    stk.push(stk.pop() + c);
                }
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        DecodeString dc = new DecodeString();
        System.out.println(dc.decodeString("3[a]2[bc]"));
        System.out.println(dc.decodeString("10[leet]"));
        System.out.println(dc.decodeString("3[a2[c]]"));
        System.out.println(dc.decodeString("2[abc]3[cd]ef"));
        System.out.println(dc.decodeString("leetcode"));
    }
}
