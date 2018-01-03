package akash;

/**
 * Created by akash on 03-01-2018.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) return -1;

        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] == 1) return cnt;
            cnt++;
        }
        return -1;
    }
}
