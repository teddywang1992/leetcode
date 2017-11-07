package facebook1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII1 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(i1, i2) -> (i1.start - i2.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>((i1, i2) ->(i1.end - i2.end));
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = heap.poll();
            if (cur.end <= intervals[i].start) {
                cur.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(cur); //最后加进去
        }

        return heap.size();
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
