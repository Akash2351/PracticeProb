package akash;

/**
 * Created by akash on 18-02-2018.
 */
public class PermutationInString {

/*Given two strings s1 and s2, write a function to return true if s2 contains
    the permutation of s1. In other words, one of the first string's
    permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False*/

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.isEmpty()) return true;
        if (s2 == null || s1.length() > s2.length()) return false;

        //use the sliding window approach..similar to other problem...
        //indices of string where anagram is found...

        int len1 = s1.length(), len2 = s2.length();
        for (int i = 0; i < len2; i++) {
            if (i + len1 > len2) break;
            if (isAnagram(s1, s2.substring(i, i + len1)))
                return true;
        }
        return false;
    }

    public boolean isAnagram(String s1, String s2) {
        int[] dict = new int[26];
        for (char c : s1.toCharArray())
            dict[c - 'a']++;
        for (char c : s2.toCharArray()) {
            dict[c - 'a']--;
            if (dict[c - 'a'] < 0) return false;
        }
        return true;
    }
}
