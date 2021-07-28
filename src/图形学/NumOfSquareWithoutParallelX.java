package 图形学;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfSquareWithoutParallelX {
    public int numOfSquare(List<Point> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int res = 0;
        Map<String, List<Point[]>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Point p1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point p2 = list.get(j);
                if (p1.x == p2.x && p1.y == p2.y) {
                    continue;
                }
                long dist = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
                double centerX = (double)(p1.x + p2.x) / 2, centerY = (double) (p1.y + p2.y) / 2;
                String info = "" + dist + "+" +centerX + "+" + centerY;
                map.computeIfAbsent(info, k-> new ArrayList<>());
                map.get(info).add(new Point[] {p1, p2});
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                List<Point[]> square = map.get(key);
                for (int i = 0; i < square.size(); i++) {
                    for (int j = i + 1 ; j< square.size(); j++) {
                        Point node1 = square.get(i)[0];
                        Point node2 = square.get(j)[0];
                        Point node3 = square.get(i)[1];
                        long len1 = distance(node1, node2);
                        long len2 = distance(node1, node2);
                        if (len1 == len2) {
                            res++;
                        }
                    }
                }

            }
        }
        return res;
    }

    private long distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
