package no56_MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        int n = intervals.size();
        if (n == 0) {
            return ret;
        }
        Comparator<Interval> comparator = new Comparator<Interval>(){
            public int compare(Interval itv1, Interval itv2) {
                return itv1.start - itv2.start;
            }
        };
        Collections.sort(intervals, comparator);
        int idx = 0;
        while (idx < n) {
            int start = intervals.get(idx).start;
            int end = intervals.get(idx).end;
            while (++idx < n && intervals.get(idx).start <= end) {
                end = Math.max(end, intervals.get(idx).end);
            } 
            ret.add(new Interval(start, end));
        }
        return ret;
    }
}