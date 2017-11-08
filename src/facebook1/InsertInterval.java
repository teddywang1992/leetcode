package facebook1;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i++).end);
        }
        result.add(new Interval(start, end));
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }

        return result;
    }
}
