package revision.graph.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        bfs(g, 2);
    }

    private static void bfs(Graph g, int v) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        visited.put(v, true);
        q.add(v);
         while (!q.isEmpty()) {
             int tmp = q.poll();
             System.out.print(tmp + " ");
             for (int i : g.adjVertices.get(tmp)) {
                 if (!visited.containsKey(i)) {
                     q.add(i);
                     visited.put(i, true);
                 }
             }
         }
    }
}
