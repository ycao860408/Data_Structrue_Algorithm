package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSTopologicalSort {
    public int[] firstOrder(int numCourse, int[][] prerequisites) {
        //预处理
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }
        //
        Map<Integer, Integer> visited = new HashMap<>(); // 0: unvisited, 1: visiting, 2: has been visited

        for (int i = 0; i < numCourse; i++) {
            visited.put(i, 0);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourse;i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)) {
                    return new int[0];
                }
            }
        }
        // res is the reverse order of the topological order!
        int[] result = new int[numCourse];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(result.length - 1 - i);
        }
        return result;
    }
    // with circle is false, without circle is true
    private boolean helper(List<List<Integer>> graph, Map<Integer, Integer> visited, List<Integer> res, int i) {
        if (visited.get(i) == 2) return true;
        if (visited.get(i) == 1) return false;

        visited.put(i, 1);
        for (int j : graph.get(i)) {
            if (!helper(graph, visited, res, j)) {
                return false;
            }
        }
        visited.put(i, 2);
        res.add(i);
        return true;
    }
}
