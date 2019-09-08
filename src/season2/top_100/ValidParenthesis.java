package season2.top_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {

    static HashMap<Character, Character> charMap;
    static Set<Character> set;

    static {
        charMap = new HashMap<>(3);
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        set = new HashSet<>(3);
        set.add('(');
        set.add('{');
        set.add('[');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                stack.push(c);
            else if (!stack.isEmpty() && c == charMap.get(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("()([])("));
    }
}
