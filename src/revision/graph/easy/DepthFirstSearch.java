package revision.graph.easy;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {
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
        dfs(g, 2);
    }

    private static void dfs(Graph g, int v) {
        Map<Integer, Boolean> visited = new HashMap<>();
        dfsUtil(g, v, visited);
    }

    private static void dfsUtil(Graph g, int v, Map<Integer, Boolean> visited) {
        visited.put(v, true);
        System.out.print(v + " ");

        for (int i : g.adjVertices.get(v)) {
            if (!visited.containsKey(i)) {
                visited.put(i, true);
                dfsUtil(g, i, visited);
            }
        }
    }
}
