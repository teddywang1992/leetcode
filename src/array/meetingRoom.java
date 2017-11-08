package array;

//先排序，然后再比较

import java.util.Arrays;
import java.util.Comparator;

public class meetingRoom {
//    public boolean canAttendMeetings(Interval[] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return true;
//        }
//
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            public int compare(apple.Interval i1, apple.Interval i2) {
//                return i1.start - i2.start;
//            }
//        });
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i - 1].end > intervals[i].start) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
//
//class Interval {
//    int start;
//    int end;
//    Interval() { start = 0; end = 0; }
//    Interval(int s, int e) { start = s; end = e; }
}

