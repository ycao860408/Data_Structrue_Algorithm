package Graph.ShortestPath.Floyd;

import java.util.Arrays;

public class Floyd {

    private int[][] convertoMatrix(Graph graph) {
        int vertices = graph.vertices;
        int [][] matrix = new int[vertices][vertices];
        for (int i = 0; i < graph.list.length; i++) {
            for (Edge edge : graph.list[i]) {
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                matrix[start][end] = weight;
            }
        }
        return matrix;
    }

    private void preProcessing(int[][] matrix, int[][] minDist) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (matrix[i][j] == 0) {
                        minDist[i][j] = Integer.MAX_VALUE;
                    } else {
                        minDist[i][j] = matrix[i][j];
                    }
                }
            }
        }
    }

    public void floyd(Graph graph) {
        int[][] matrix = convertoMatrix(graph);
        int n = graph.vertices;
        int[][] minDist = new int[n][n];
        preProcessing(matrix, minDist);
        for (int k = 0; k < n; k++) {
            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (minDist[i][k] != Integer.MAX_VALUE && minDist[k][j] != Integer.MAX_VALUE ) {
                        minDist[i][j] = Math.min(minDist[i][j],minDist[i][k] + minDist[k][j]);
                    }
                }
            }
        }
        print(minDist);
    }

    private void print(int[][] minDist) {
        int n = minDist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && minDist[i][j] != Integer.MAX_VALUE)
                    System.out.println(i + " ---> " + j + " 's shortest distance: " + minDist[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(1, 0, 4);
        graph.addEdge(0, 2, -2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(3, 1, -1);
        graph.addEdge(2, 3, 2);
        Floyd fl = new Floyd();
        fl.floyd(graph);
    }
}
