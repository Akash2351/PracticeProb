package akash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akash on 07-03-2018.
 */
public class CourseSchedule {
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have
to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs,
is it possible for you to finish all courses?
For example:
      2, [[1,0]]
  There are a total of 2 courses to take.
   To take course 1 you should have finished course 0. So it is possible.

   2, [[1,0],[0,1]]
    There are a total of 2 courses to take.
     To take course 1 you should have finished course 0,
     and to take course 0 you should also have finished course 1. So it is impossible.
    */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) return true;
        if (prerequisites.length == 0 || prerequisites.length == 1) return true;

        //store all edges in a map..
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int edges = prerequisites.length;

        for (int i = 0; i < edges; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            if (!map.containsKey(u)) {
                List<Integer> list = new ArrayList<>();
                map.put(u, list);
            }
            map.get(u).add(v);
        }

        List<Integer> visitedList = new ArrayList<>();

        //for each edge, starting from u, check for a cycle
        for (int u : map.keySet()) {
            visitedList.clear();
            if (isCyclePresent(u, map, visitedList)) return false;
        }
        return true;
    }

    public boolean isCyclePresent(int node, HashMap<Integer, List<Integer>> map, List<Integer> visited) {
        if (!map.containsKey(node)) return false;

        for (int v : map.get(node)) {
            if (visited.contains(v)) return true;

            visited.add(node);
            if (isCyclePresent(v, map, visited)) return true;
            visited.remove(visited.size() - 1);
        }
        return false;
    }
}
