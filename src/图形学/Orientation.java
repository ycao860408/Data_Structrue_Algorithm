package 图形学;

public class Orientation {

    public static int orientation(Point p, Point q, Point r) {
        int res = (q.x - p.x) * (r.y - q.y) - (q.y - p.y) * (r.x - q.x);
        if (res == 0) return 0;
        return res > 0 ? 1 : -1;
    }

    public static String checkOrientation(Point p, Point q, Point r) {
        int res = orientation(p, q, r);
        if (res == 0) return "Moving along a strait line";
        else if (res > 0) {
            return "Rotating with counter clockwise";
        } else {
            return "Rotating with clockwise";
        }
    }
}
