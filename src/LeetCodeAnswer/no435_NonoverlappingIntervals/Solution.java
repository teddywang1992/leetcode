package LeetCodeAnswer.no435_NonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

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
	public int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.end, i2.end);
			}
		});
		long last = Long.MIN_VALUE;
		int count = intervals.length;
		for (Interval i : intervals) {
			if (last <= i.start) {
				last = i.end;
				count--;
			}
		}
		return count;
	}
}