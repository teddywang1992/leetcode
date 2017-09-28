package array;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        System.out.println(intervals.get(0).start);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));//别忘加最后一个

        return result;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
