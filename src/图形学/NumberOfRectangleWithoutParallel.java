package 图形学;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfRectangleWithoutParallel {
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
            int n = map.get(key).size();
            if (n <= 1) continue;
            res += factorial(n) / (factorial(n - 2) * factorial(2));
        }

        return res;
    }

    private long distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

}