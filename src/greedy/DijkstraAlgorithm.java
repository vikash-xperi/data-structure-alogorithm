package greedy;

import java.util.*;

class Edge {
    int dest;
    int weight;

    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return dest + " : " + weight;
    }
}
class Graph {
    private int V;
    public List<Edge> edges[];
    private Map<Integer, Edge> edgeRef;

    Graph(int v) {
        this.V = v;
        edges = new LinkedList[v + 1];
        edgeRef = new HashMap<>();

        for (int i = 1; i <=v; ++i) {
            edges[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w, int weight) {
        edges[v].add(edgeRef.getOrDefault(v, new Edge(w, weight)));
    }

    void printGraph() {
        for (int i = 1; i <= V; ++i) {
            System.out.println(i + "->" + edges[i]);
        }
    }
}
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 6);
        graph.printGraph();


    }
}
