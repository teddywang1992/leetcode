package no253_MeetingRoomsII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return i1.start - i2.start;
        	}
		});
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (Interval i : intervals) {
            if (heap.size() != 0 && heap.peek() <= i.start) heap.poll();
            heap.offer(i.end);
        }
        return heap.size();
//		int[] starts = new int[intervals.length];
//		int[] ends = new int[intervals.length];
//		for (int i = 0; i < intervals.length; i++) {
//			starts[i] = intervals[i].start;
//			ends[i] = intervals[i].end;
//		}
//		Arrays.sort(starts);
//		Arrays.sort(ends);
//		int rooms = 0;
//		int endsItr = 0;
//		for (int i = 0; i < starts.length; i++) {
//			if (starts[i] < ends[endsItr])
//				rooms++;
//			else
//				endsItr++;
//		}
//		return rooms;
	}
}