package Graph.classicalSearchingMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void dfs(List<GraphNode> list) {
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode node : list) {
            if (!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    private static void helper(GraphNode node, Set<GraphNode> visited) {
        visited.add(node);
        System.out.println(node.label);
        for (GraphNode next : node.neighbors) {
            if (!visited.contains(next)) {
                helper(next, visited);
            }
        }
    }

    public static void dfs1(GraphNode node) {
        helper(node, new HashSet<>());
    }

    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                helper2(matrix, visited, i);
            }
        }
    }

    public static void dfsIteration(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);
        while (!stack.isEmpty()) {
            GraphNode cur = stack.pop();
            System.out.println(cur.label);

            for (GraphNode next : cur.neighbors) {
                if (!visited.contains(next)) {
                    stack.push(next);
                    visited.add(next);
                }
            }
        }
    }

    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);

                while (!stack.isEmpty()) {
                    int cur = stack.pop();
                    System.out.println(cur);
                    for (int j = 0; j < visited.length; j++) {
                        if (visited[j] == 0 && matrix[cur][j] == 1) {
                            visited[j] = 1;
                            stack.push(j);
                        }
                    }
                }
            }
        }

    }

    private static void helper2(int[][] matrix, int[] visited, int idx) {
        visited[idx] = 1;
        System.out.println(idx);
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0 && matrix[idx][i] != 0) {
                helper2(matrix, visited, i);
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

        dfs1(a);
        System.out.println();
        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };
        dfsMatrix(matrix);
        System.out.println();
        dfsIteration(a);
        System.out.println();
        dfsMatrixIteration(matrix);
    }
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