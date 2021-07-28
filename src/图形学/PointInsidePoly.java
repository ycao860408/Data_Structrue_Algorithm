package 图形学;

public class PointInsidePoly {
    public boolean pointInPolygon(Point[] polygon, Point point) {
        Point extreme = new Point(Integer.MAX_VALUE, point.y);
        int count = 0;
        for (int i = 0; i < polygon.length; i++) {
            int next = (i + 1) % polygon.length;
            if (SegmentCrossing.segmentIntersect(polygon[i],polygon[next], point, extreme )) {
                if (Orientation.orientation(polygon[i], point, polygon[next]) == 0) {
                    return PointOnSegment.pointOnSegment(point, polygon[i], polygon[next]);
                }
                count++;
            }
        }
        return count % 2 == 1;
    }
}
