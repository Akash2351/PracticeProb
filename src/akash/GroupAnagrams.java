package akash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akash on 24-11-2017.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"ant", "tna", "bat", "abc"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        //store the strings as keys...sort and store..so anagrams
        // will be same string
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted))
                map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
