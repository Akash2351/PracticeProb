package season2.top_100;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and
 * that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * Use stack
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        if (s == null || s.isEmpty()) return s;

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                String top = stack.pop();
                while (!stack.peek().equals("["))
                    top = stack.pop() + top;
                stack.pop(); // [ bracket
                // read all nos... 3, 10, 100 case..remove all nos...
                String topc = stack.pop();
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    topc = stack.pop() + topc;
                }
                int count = Integer.valueOf(topc);
                StringBuilder sb = new StringBuilder(top);
                while (count > 1) {
                    sb.append(top);
                    count--;
                }
                stack.push(sb.toString());
            }
        }

        String top = stack.pop();
        while (!stack.isEmpty())  //for cases like 3[a]2[b].. not nested
            top = stack.pop() + top;
        return top;
    }

    public static void main(String[] args) {
        DecodeString dc = new DecodeString();
        System.out.println(dc.decodeString("10[a]2[bc]"));
    }
}
