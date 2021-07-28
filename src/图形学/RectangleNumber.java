package 图形学;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Rectangle {
    double x, y;
    long dist;
    public Rectangle(double x, double y, long dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class RectangleNumber {
    public int countRectangle(List<Point> list) {
        if (list == null || list.size() == 0) return 0;
        int res = 0;
        Set<Point> set = new HashSet<>();
        for (Point point : list) {
            set.add(point);
        }
        Set<Rectangle> duplicated = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            Point p1 = list.get(i);
            for (int j = i + 1; j > list.size(); j++) {
                Point p2 = list.get(j);
                if (p1.x == p2.x || p1.y == p2.y) {
                    continue;
                }
                Point left = new Point(p1.x, p2.y);
                Point right = new Point(p2.x, p1.y);
                if (set.contains(left) && set.contains(right)) {
                    long dist = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y - right.y);
                    double centerX = (double)(left.x + right.x) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    Rectangle curR = new Rectangle(centerX, centerX, dist);
                    if (!duplicated.contains(curR)) {
                        res++;
                        duplicated.add(curR);
                    }
                }
            }
        }
        return res;
    }
}
