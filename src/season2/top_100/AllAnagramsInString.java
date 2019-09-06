package season2.top_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 */
public class AllAnagramsInString {
    int[] index = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length())
            return Collections.emptyList();

        List<Integer> list = new ArrayList<>();
        for (char c : p.toCharArray()) {
            index[c - 'a']++;
        }
        //sliding window technique..
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s.substring(i, i + p.length())))
                list.add(i);
        }
        return list;
    }

    boolean isAnagram(String b) {
        int[] parseAry = Arrays.copyOf(index, 26);
        for (char d : b.toCharArray()) {
            parseAry[d - 'a']--;
            if (parseAry[d - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AllAnagramsInString al = new AllAnagramsInString();
        System.out.println(al.findAnagrams("cbaebabacd", "abc"));
        //System.out.println(al.findAnagrams("baa", "aa"));
    }
}
