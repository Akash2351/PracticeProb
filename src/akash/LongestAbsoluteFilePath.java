package akash;

import java.util.Stack;

/**
 * Created by akash on 05-01-2018.
 */
public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        LongestAbsoluteFilePath pt = new LongestAbsoluteFilePath();
        System.out.println(pt.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\\ ");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int level = countLevel(s);

            // if current directory/file depth is lower that the top directory/file on the stack, pop from stack
            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            // +1 here because a "/" needs to be counted following each diretory
            int len = s.replaceAll("\\	", "").length() + 1;
            curLen += len;

            // if s contains ".", we have found a file!
            if (s.contains(".")) {
                result = curLen - 1 > result ? curLen - 1 : result;
            }
            stack.add(len);
        }
        return result;
    }

    private int countLevel(String s) {
        String cur = s.replaceAll("\\	", "");
        return s.length() - cur.length();
    }
}
