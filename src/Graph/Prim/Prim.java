package Graph.Prim;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
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

        Prim prim = new Prim();
        prim.primMST(graph);
    }

    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        // weight, vertex
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() == o2.getKey()) {
                    return o1.getValue() - o2.getValue();
                }
                return o1.getKey() - o2.getKey();
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curPair = pq.poll();
            int curVertex = curPair.getValue();
            visited[curVertex] = true;
            List<Edge> curNext = graph.list[curVertex];
            for (Edge curNextEdge : curNext) {
                if (!visited[curNextEdge.end]) {
                    int nextVertex = curNextEdge.end;
                    int nextWeight = curNextEdge.weight;
                    if (nextWeight < minDist[nextVertex]) {
                        pq.offer(new Pair(nextWeight, nextVertex));
                        parents[nextVertex] = curVertex;
                        minDist[nextVertex] = nextWeight;
                    }
                }
            }
        }
        print(parents, minDist, graph.vertices);
    }

    private void print(int[] parents, int[] minDists, int vertices) {
        int total = 0;
        System.out.println("MST: ");
        for (int i = 1; i < parents.length; i++) {
            System.out.println("Edge: " + i  + "--"+ parents[i] + " minDist : " + minDists[i]);
            total += minDists[i];
        }
        System.out.println("Total : " + total);
    }

}
