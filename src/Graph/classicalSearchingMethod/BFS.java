package Graph.classicalSearchingMethod;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public static void bfs(GraphNode node) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            System.out.println(cur.label);
            for (GraphNode next : cur.neighbors) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
    }

    public static void bfs2(GraphNode node) { // 最短距离的写法！！！
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                GraphNode cur = queue.poll();
                System.out.print(cur.label + " ");
                for (GraphNode next : cur.neighbors) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void bfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    System.out.println(cur);
                    for (int j = 0; j < matrix.length; j++) {
                        if (visited[j] == 0 && matrix[cur][j] == 1) {
                            visited[j] = 1;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }

    public static void bfsMatrix2(int[][] matrix) { // 最短距离和层序遍历的写法！！！
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int cur = queue.poll();
                        System.out.print(cur + " ");
                        for (int k = 0; k < visited.length; k++) {
                            if (visited[k] == 0 && matrix[cur][k] == 1) {
                                visited[k] = 1;
                                queue.offer(k);
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(f);
        a.neighbors.add(d);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(d);
        e.neighbors.add(b);
        e.neighbors.add(c);

        f.neighbors.add(a);

        bfs(a);
        System.out.println();
        bfs2(a);
        System.out.println();
        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };
        bfsMatrix(matrix);
        System.out.println();
        bfsMatrix2(matrix);
    }
    /*        this is an undirected graph
     *               0
     *             / | \
     *            3  1  5
     *            | /|
     *            |/ |
     *            4  |
     *             \ |
     *              \|
     *               2
     * */
}
