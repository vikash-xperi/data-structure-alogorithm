package revision.graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public Map<Integer, List<Integer>> adjVertices = new HashMap<>();

    public void addVertex(int label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adjVertices.get(v).add(w);
    }
}
