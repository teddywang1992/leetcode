package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
再来一看一种使用最小堆来解题的方法，这种方法先把所有的时间区间按照起始时间排序，然后新建一个最小堆，开始遍历时间区间，
如果堆不为空，且首元素小于等于当前区间的起始时间，我们去掉堆中的首元素，把当前区间的结束时间压入堆，由于最小堆是小的在前面，
那么假如首元素小于等于起始时间，说明上一个会议已经结束，可以用该会议室开始下一个会议了，所以不用分配新的会议室，
遍历完成后堆中元素的个数即为需要的会议室的个数，参见代码如下；
 */

public class MeetingRoomsII {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(minMeetingRooms(intervals));
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current = heap.poll();

            if (intervals[i].start >= current.end) {
                current.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }

            heap.offer(current);
        }

        return heap.size();
    }
}


