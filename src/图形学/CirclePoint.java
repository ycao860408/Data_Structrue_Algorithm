package 图形学;

public class CirclePoint {
    public static int circlePoint(double r) {
        int res = 0;

        for (int x = 0; x <= r; x++) {
            int y = (int) Math.sqrt(r * r - x * x);
            res += y;
        }
        return res * 4 + 1;
    }

    public static void main(String[] args) {
        System.out.println(circlePoint(3));
    }
}
