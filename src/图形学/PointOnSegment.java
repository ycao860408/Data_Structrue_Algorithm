package 图形学;

public class PointOnSegment {
    public static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    public static boolean pointOnSegment(Point C, Point A, Point B) {
        // check whether C is on the segment AB;
        Point AC = new Point(C.x - A.x, C.y - A.y);
        Point BC = new Point(C.x - B.x, C.y - B.y);
        int res = AC.x * BC.y - AC.y * BC.x;
        return res == 0 && onSegment(A, C, B);
    }
}
