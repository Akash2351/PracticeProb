package season2.top_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();

        List<String> list = new ArrayList<>();
        generate(n, 0, 0, "", list);
        return list;
    }

    void generate(int n, int left, int right, String sb, List<String> list) {
        if (left == right && left == n) {
            list.add(sb);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, sb + "(", list);
            if (left > right) {
                generate(n, left, right + 1, sb + ")", list);
            }

        } else {
            generate(n, left, right + 1, sb + ")", list);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3))
        ;
    }
}
