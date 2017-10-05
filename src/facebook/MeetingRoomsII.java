package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        heap.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval endSoon = heap.poll();
            if(endSoon.end <= intervals[i].start){
                endSoon.end = intervals[i].end;
            }
            else{
                heap.add(intervals[i]);
            }
            heap.add(endSoon);
        }
        return heap.size();
    }
}
