package no57_InsertInterval;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int index = 0;
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            res.add(intervals.get(index++));
        }
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
            index++;
        }
        res.add(newInterval);
        while (index < intervals.size()) res.add(intervals.get(index++));
        return res;
    }
}