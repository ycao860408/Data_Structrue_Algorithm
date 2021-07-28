package sortingAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        if (a.start == b.start) {
            return a.end - b.end;
        }
        return a.start - b.start;
    }
}

public class ArraysSortCompare {
    public static void main(String[] args) {
        int [] starts = new int[] {2, 3, 5, 3, 6, 8, 3};
        int [] ends = new int[] {6, 4, 7, 7, 8, 9, 10};
        Interval [] intervals = new Interval[starts.length];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(starts[i], ends[i]);
        }

        Interval [] temp;
        test((temp = Arrays.copyOf(intervals, intervals.length)));
        System.out.println(Arrays.toString(temp));
        Arrays.sort((temp = Arrays.copyOf(intervals, intervals.length)), new IntervalComparator());
        System.out.println(Arrays.toString(temp));
    }

    public static void test(Interval [] intervals) {
        Arrays.sort(intervals, (a, b) ->(a.end - b.end));
    }

}
