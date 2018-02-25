package akash;

import java.util.*;

/**
 * Created by akash on 25-02-2018.
 */
public class WordLadder {

  /*Given two words (beginWord and endWord), and a dictionary's word list,
   find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
            return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.  */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int dist = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        wordList.add(endWord);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                //find adjacent strings from dictionary and
                //add to queue...run bfs..
                String cur = queue.remove();
                List<String> adj = getAdjacentString(cur, wordList);
                if (!adj.isEmpty()) {
                    //add all adjacent strings.. and also remove from the dict
                    if (adj.contains(endWord)) {
                        return dist + 1;
                    }
                    queue.addAll(adj);
                    wordList.removeAll(adj);
                }
                levelSize--;
            }
            dist++; // checking next adjacents...one more branch...so distance increases
        }

        return 0;
    }

    public List<String> getAdjacentString(String cur, List<String> wordList) {
        int[] dict = new int[26];
        for (char c : cur.toCharArray())
            dict[c - 'a']++;

        List<String> adjacents = new ArrayList<>();

        for (String word : wordList) {
            int[] dClone = dict.clone();
            for (char c : word.toCharArray())
                dClone[c - 'a']--;

            // one char added, one char removed...for 1 char change..so sum ==0
            if (Arrays.stream(dClone).filter(t -> t == -1).count() == 1) {
                adjacents.add(word);
            }
        }
        return adjacents;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        //List<String> list =  new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(wl.ladderLength("hit", "cog", list));
        System.out.println(wl.ladderLength2("hit", "cog", new HashSet<>(list)));
    }

    public int ladderLength2(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}
