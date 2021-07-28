package 图形学;

public class PointWithInTriangle {
    public static double getArea(Point p1, Point p2, Point p3) {
        int x1 = p1.x - p2.x, y1 = p1.y - p2.y;
        int x2 = p1.x - p3.x, y2 = p1.y - p3.y;
        return Math.abs(x1 * y2 - x2 * y1) / 2.0;
    }

    public static boolean isInside(Point a, Point b, Point c, Point o) {
        double areaOfTriangle = getArea(a, b, c);
        double area1 = getArea(a, b, o);
        double area2 = getArea(a, c, o);
        double area3 = getArea(b, c, o);

        if (area1 == 0 || area2 == 0 || area3 == 0) {
            return true;
        }
        return areaOfTriangle == area1 + area2 + area3;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 0);
        Point b = new Point(0, 1);
        Point c = new Point(-3, -3);
        Point o = new Point(0, 0);
        System.out.println(isInside(a, b, c, o));
    }
}
