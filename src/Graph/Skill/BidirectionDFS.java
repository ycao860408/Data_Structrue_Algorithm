package Graph.Skill;

import Graph.classicalSearchingMethod.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BidirectionDFS {
    public static int shortDistanceBiD(GraphNode start, GraphNode end) {
        Queue<GraphNode> startQueue = new LinkedList<>();
        Queue<GraphNode> endQueue  = new LinkedList<>();
        Set<GraphNode> startSet = new HashSet<>();
        Set<GraphNode> endSet = new HashSet<>();

        startQueue.offer(start);
        endQueue.offer(end);
        startSet.add(start);
        endSet.add(end);
        Queue<GraphNode> curQueue;
        Set<GraphNode> curSet, oppSet;
        int res = 0;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            if (startQueue.size() < endQueue.size()) {
                curQueue = startQueue;
                curSet = startSet;
                oppSet = endSet;
            } else {
                curQueue = endQueue;
                curSet = endSet;
                oppSet = startSet;
            }
            int size = curQueue.size();
            res++;
            for (int i = 0; i < size; i++) {
                GraphNode curNode = curQueue.poll();
                for (GraphNode next : curNode.neighbors) {
                    if (oppSet.contains(next)) {
                        return res - 1;
                    }
                    if (!curSet.contains(next)) {
                        curQueue.offer(next);
                        curSet.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
