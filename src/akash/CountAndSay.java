package akash;

/**
 * Created by akash on 15-11-2017.
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String[] list = new String[n + 1];
        list[1] = "1";
        list[2] = "11";

        for (int i = 3; i <= n; i++) {
            char[] chars = list[i - 1].toCharArray();
            int len = chars.length;
            int j = 0;
            StringBuffer sb = new StringBuffer();
            while (j < len - 1) {
                int cnt = 1;
                while (j < len - 1 && chars[j] == chars[j + 1]) {
                    j++;
                    cnt++;
                }
                sb.append(cnt).append(chars[j]);
                j++;
                //if its the last character...
                if (j == len - 1)
                    sb.append(1).append(chars[j]);
            }
            list[i] = sb.toString();
        }
        return list[n];
    }
}
