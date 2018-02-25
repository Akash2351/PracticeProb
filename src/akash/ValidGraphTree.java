package akash;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by akash on 24-02-2018.
 */
public class ValidGraphTree {

/*    //matrix based input..does not check cycles...
    public boolean validTree(int n, int[][] edges) {
        if(n<=1) return true;

        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();

        //dfs
        stack.add(0);
        visited[0] = 1;

        while(!stack.isEmpty()){
            int node = stack.peek();
            int notVisitedNode  = getUnvisitedNode(node,edges,visited);
            if(notVisitedNode != -1){
                stack.push(notVisitedNode);
                visited[notVisitedNode] = 1;
            } else {
                stack.pop();
            }
        }

        System.out.println(Arrays.toString(visited));
        int visitedNodes = (int)Arrays.stream(visited).filter(t -> t==1? true: false).count();
        if(visitedNodes == n) return true;


        return false;

    }

    public int getUnvisitedNode(int node, int[][] edges, int[] visited){
        for(int i=0; i<edges[0].length; i++)
            if(edges[node][i] == 1 && visited[i]!=1) return i;

        return -1;
    }

    public static void main(String[] args) {
        ValidGraphTree graph = new ValidGraphTree();
        int grph[][] = new int[][]{
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        System.out.println(graph.validTree(5,grph));
    }*/



/*  Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 (each edge is a pair of nodes), write a function to check whether these
  edges make up a valid tree.
    For example:
    Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
    Note: you can assume that no duplicate edges will appear in edges.
    Since all edges are undirected, [0, 1] is the same as [1, 0] and thus
     will not appear together in edges*/


    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);

        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());

        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        //dfs
        stack.add(edges[0][0]);
        visited[edges[0][0]] = true;

        while (!stack.isEmpty()) {
            int node = stack.peek();
            int notVisitedNode = getUnvisitedNode(node, adjList, visited);
            if (notVisitedNode != -1) {
                stack.push(notVisitedNode);
                visited[notVisitedNode] = true;
            } else {
                stack.pop();
            }
        }
        //check for cycles...if edges = n-1, no cycles
        if (edges.length > n - 1)
            return false;

        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public int getUnvisitedNode(int node, List<List<Integer>> adjList, boolean[] visited) {
        List<Integer> list = adjList.get(node);
        if (list == null) return -1;
        for (Integer n : list)
            if (!visited[n]) return n;

        return -1;
    }

    public static void main(String[] args) {
        ValidGraphTree graph = new ValidGraphTree();
        int grph[][] = new int[][]{
                {1, 0},
                {2, 0}};
        System.out.println(graph.validTree(3, grph));
    }
}
