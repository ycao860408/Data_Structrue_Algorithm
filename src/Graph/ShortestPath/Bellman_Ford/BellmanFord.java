package Graph.ShortestPath.Bellman_Ford;

import java.util.Arrays;

public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        for (int i = 1; i <= graph.vertices; i++) {
            relaxation(graph, minDist, i);
        }
        print(minDist);
    }

    private void print(int[] minDists) {
        System.out.println("Shortest Distance from 0");

        for (int i = 0; i < minDists.length; i++) {
            System.out.println("0 ---> " + i + " 's shortest distance: " + minDists[i]);
        }
    }

    private void relaxation(Graph graph, int[] minDist, int i) {
        for (int j = 0; j < graph.allEdges.size(); j++) {
            Edge edge = graph.allEdges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                minDist[end] = minDist[start] + weight;
                if (i == graph.vertices) {
                    System.out.println("Negative Weight Circle !");
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2, 1, 1);
        graph.addEdge(3, 2, -2);
        graph.addEdge(1, 3, 2);
        graph.addEdge(4, 3, -1);
        graph.addEdge(4, 1, -4);
        graph.addEdge(5, 4, 1);
        graph.addEdge(0, 5, 8);
        graph.addEdge(0, 1, 10);
        BellmanFord bf = new BellmanFord();
        bf.bellmanFord(graph);
    }
}
