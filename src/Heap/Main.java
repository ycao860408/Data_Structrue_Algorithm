package Heap;

import sortingAlgorithm.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void compare1() {
        int[] nums = new int[] {1, 2, 3, 4};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    public static void compare2() {
        int[] nums = new int[] {1, 2, 3, 4};
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            pq.offer(num);
        }

        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    public static void compare3() {
        int[] nums = new int[] {1, 2, 3, 4};
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b - a));
        // lambda expression
        for (int num : nums) {
            pq.offer(num);
        }

        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    private static  class Point{
        int x, y;
        int weight;
        public Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void compare4() {
        Point[] points = new Point[]{
                new Point(0, 0, 1),
                new Point(0, 1, 3),
                new Point(2, 2, 4),
                new Point(-1, 2, 1)
        };
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.weight == o2.weight) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o1.weight - o2.weight;
            }
        });

        for (Point p : points) {
            pq.offer(p);
        }
        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    public static void compare5() {
        Point[] points = new Point[]{
                new Point(0, 0, 1),
                new Point(0, 1, 3),
                new Point(2, 2, 4),
                new Point(-1, 2, 1)
        };
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b)->(-a.weight + b.weight));

        for (Point p : points) {
            pq.offer(p);
        }
        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    public static void compare6() {
        int[] nums = new int[] {1, 2, 3, 4};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // lambda expression
        for (int num : nums) {
            pq.offer(num);
        }

        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }
    public static void main(String[] args) {
        compare1();
        compare2();
        compare3();
        compare4();
        compare5();
        compare6();
        String[] strs = new String[]{"12", "34","7","67"};
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        System.out.println(Arrays.toString(strs));
        int[] arr1 = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[] {3, 4, 5, 2};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));

        pq.offer(arr1);
        pq.offer(arr2);
        System.out.println(Arrays.toString(pq.poll()));
        System.out.println(Arrays.toString(pq.poll()));
    }
}
