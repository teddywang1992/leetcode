package LeetCodeAnswer.no436_FindFlightInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

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
	public int[] findRightInterval(Interval[] intervals) {
		int[] result = new int[intervals.length];
		// map records the index for each start point
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i].start, i);
		}

		// sort according to start point
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			};
		});

		// binary search to insert current end point to larger sorted start
		// points
		for (int i = 0; i < intervals.length; i++) {
			int target = intervals[i].end;
			int left = i + 1, right = intervals.length;
			while (left < right) {
				int mid = (right - left) / 2 + left;
				if (intervals[mid].start < target)
					left = mid + 1;
				else
					right = mid;
			}
			result[map.get(intervals[i].start)] = (right == intervals.length) ? -1
					: map.get(intervals[right].start);
		}
		return result;
	}
}