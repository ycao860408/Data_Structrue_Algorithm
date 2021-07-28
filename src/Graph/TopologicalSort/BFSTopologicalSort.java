package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTopologicalSort {

    public int[] findres(int numCourse, int[][] prerequisites) {
        int[] res = new int[numCourse];
        int[] indegrees = new int[numCourse];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegrees[pair[0]]++;
        }
        int k = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if (indegrees[i] == 0) {
                res[k++] = i;
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    res[k++] = next;
                    que.offer(next);
                }
            }
        }

        return k == numCourse? res : new int[0];
    }
}
