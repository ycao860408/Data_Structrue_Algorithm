package Graph.Kruskal;

import Graph.Prim.Prim;
import UnionFind.impl.FinalUFImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);

        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);
    }

    public void kruskalMST(Graph graph) {
        Collections.sort(graph.allEdges, (a, b) ->(a.weight - b.weight));
        List<Edge> res = new ArrayList<>();
        FinalUFImpl uf = new FinalUFImpl(graph.vertices);
        for (Edge edge : graph.allEdges) {
            if (res.size() >= graph.vertices - 1) break;
            int start = edge.start;
            int end = edge.end;
            if (uf.connected(start, end)) continue;
            uf.union(start, end);
            res.add(edge);
        }

        if (res.size() == graph.vertices - 1) {
            System.out.println("Success!");
            int total = 0;
            for (Edge ele : res) {
                System.out.println(ele.start + "--" +  ele.end + ", weight : " + ele.weight);
                total+= ele.weight;
            }
            System.out.println("total: " + total);
        } else {
            System.out.println("no MST");
        }
    }
}
