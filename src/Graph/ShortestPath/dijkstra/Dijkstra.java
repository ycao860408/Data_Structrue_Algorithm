package Graph.ShortestPath.dijkstra;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public void dijkstra(Graph graph) {
        boolean [] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() == o2.getKey()) {
                    return o1.getValue() - o2.getValue();
                }
                return o1.getKey() - o2.getKey();
            }
        });

        pq.offer(new Pair<>(minDist[0], 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curPair = pq.poll();
            int curVertex = curPair.getValue();
            //int curDistant = curPair.getKey();
            visited[curVertex] = true;
            List<Edge> nextEdges = graph.list[curVertex];
            for (Edge nextEdge : nextEdges) {
                int nextVertex = nextEdge.end;
                int nextWeight = nextEdge.weight;
                if (!visited[nextVertex]) {
                    if (minDist[curVertex] + nextWeight <  minDist[nextVertex]) {
                        minDist[nextVertex] = minDist[curVertex] + nextWeight;
                        pq.offer(new Pair<>(minDist[nextVertex], nextVertex));
                    }
                }
            }
        }
        print(minDist);
    }

    private void print(int[] minDists) {
        System.out.println("Shortest Distance from 0");

        for (int i = 0; i < minDists.length; i++) {
            System.out.println("0 ---> " + i + " 's shortest distance: " + minDists[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);

        Dijkstra shortestDistance = new Dijkstra();
        shortestDistance.dijkstra(graph);
    }
}
