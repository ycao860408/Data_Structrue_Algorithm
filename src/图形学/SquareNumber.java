package 图形学;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Square {
    double x, y;
    long dist;
    public Square(double x, double y, long dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class SquareNumber {
    public int countSquare(List<Point> list) {
        if (list.size() == 0) return 0;
        int res = 0;
        Set<Point> set = new HashSet<>();
        for (Point point : list) {
            set.add(point);
        }
        Set<Square> duplicate = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                if (Math.abs(node1.x - node2.x) != Math.abs(node1.y - node2.y) || node1.x == node2.x || node2.y == node1.y) {
                    continue;
                }
                Point left = new Point(node1.x, node2.y);
                Point right = new Point(node2.x, node1.y);
                if (set.contains(left) && set.contains(right)) {
                    long dist = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y  - right.y);
                    double centerX = (double)(left.x + right.y) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    Square curSquare = new Square(centerX, centerY, dist);
                    if (duplicate.contains(curSquare)) {
                        continue;
                    }
                    duplicate.add(curSquare);
                    res++;
                }
            }
        }
        return res ;
    }
}
