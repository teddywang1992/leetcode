package facebook2;

import facebook1.Interval;

import java.util.Arrays;

public class MinimumCoverInterval {
    //--------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------//

//
//    Find least number of intervals from A that can fully cover B
//    For example:
//        Given A=[[0,3],[3,4],[4,6],[2,7]] B=[0,6] return 2 since we can use [0,3] [2,7] to cover the B
//        Given A=[[0,3],[4,7]] B=[0,6] return 0 since we cannot find any interval combination from A to cover the B

// make sure every time we choose one interval we cover more time
// every time we choose one, make the start time as its end time
// Always choose the interval that whose end time is the biggest
// and start time is smaller or equal to current start time
// util we got the end time bigger than input.end

//        'time complexity: O(nlgn)'
    public static void main(String[] args) {
        Interval a1 = new Interval(0,2);
        Interval a2 = new Interval(1,3);
        Interval a3 = new Interval(2,6);
        Interval a4 = new Interval(0,7);
        Interval b1 = new Interval(0,6);
        Interval[] intervals = new Interval[]{a1,a2,a3,a4};
        System.out.println(findCover(intervals,b1));
    }

    public static int findCover(Interval[] intervals, Interval interval) {
        Arrays.sort(intervals, (inter1, inter2) -> {
            if (inter1.start == inter2.start) {
                return inter1.end - inter2.end;
            }
            return inter1.start - inter2.start;
        });
        int count = 0;
        int start = interval.start;
        int end = -1;
        int index = 0;
        while (index < intervals.length && end < interval.end) {
            if (intervals[index].end <= start) {
                index++;
                continue;
            }
            if (intervals[index].start > start) {
                break;
            }
            while (index < intervals.length && end < interval.end && intervals[index].start <= start) {
                end = Math.max(intervals[index].end, end);
                index++;
            }
            if (start != end) {
                count++;
                start = end;
            }
        }
        if (end < interval.end) {
            return 0;
        }
        return count;
    }
}
