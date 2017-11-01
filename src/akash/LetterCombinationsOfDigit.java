package akash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akash on 01-11-2017.
 */
public class LetterCombinationsOfDigit {

    public static void main(String[] args) {
        LetterCombinationsOfDigit lc = new LetterCombinationsOfDigit();
        lc.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        //store the key combinations in a map
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put("0", "");

        //for storing the strings..
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.isEmpty())
            return list;

        printRecursive(digits, 0, map, "", list);
        return list;
    }

    //recursive program that appends all possible combinations of a key, calls the function
    //recursively.  eg "23" -> "a_","b_","c_" in first loop, "ad","ae","af"...etc
    public void printRecursive(String digits, int index, HashMap<String, String> map,
                               String comb, List<String> list) {
        //base case..
        if (index == digits.length()) {
            list.add(comb);
            return;
        }
        String chars = map.get(String.valueOf(digits.charAt(index)));
        if (chars.length() == 0) //check for 0 and 1..
            return;
        //else append and recursively call..abc
        for (int i = 0; i < chars.length(); i++) {
            printRecursive(digits, index + 1, map, comb + chars.charAt(i), list);
        }
    }
}
