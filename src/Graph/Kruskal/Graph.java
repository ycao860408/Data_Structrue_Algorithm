package Graph.Kruskal;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int vertices;
    public List<Edge>  allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end, int weight) {
        Edge e = new Edge(start, end, weight);
        allEdges.add(e);
    }
}
