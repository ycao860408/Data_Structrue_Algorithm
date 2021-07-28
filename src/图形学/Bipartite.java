package 图形学;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        int color = 0;
        for (int i = 0; i < graph.length;i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                Queue<Integer> que = new LinkedList<>();
                que.offer(i);
                while (!que.isEmpty()) {
                    int curIndex = que.poll();
                    for (int j = 0; j < graph.length; j++) {
                        if (colors[graph[curIndex][j]] == colors[curIndex]) {
                            return false;
                        } else if (colors[graph[curIndex][j]] == 0) {
                            colors[graph[curIndex][j]] = -1 * colors[curIndex];
                            que.offer(graph[curIndex][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
