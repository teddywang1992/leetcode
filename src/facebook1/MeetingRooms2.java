package facebook1;

import java.util.Arrays;

public class MeetingRooms2 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        int end = -1;
        for (Interval interval : intervals) {
            if (interval.start < end) {
                return false;
            }
            end = interval.end;
        }

        return true;
    }
}
