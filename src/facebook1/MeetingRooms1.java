package facebook1;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms1 {
    public boolean canAttendMeetings(MeetingRooms.Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }

        return true;
    }
}
