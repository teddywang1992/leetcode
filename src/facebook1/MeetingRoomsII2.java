package facebook1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII2 {

    public int minMeetingRooms1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= heap.peek()) {
                heap.poll();
            }
            heap.offer(intervals[i].end);
        }

        return heap.size();
    }
}
