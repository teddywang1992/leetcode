package LeetCodeAnswer.uber;

/*
Problem

Given 2 sets of intervals.

Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.

Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but :
* [0, 0], [1, 2] is not valid, because you can write it as [0, 2]. 
* [0, 2], [1, 5] is not valid as well, since these two intervals intersect.

You need to find the AND operation of these two sets. For example:

1st set: [0, 2], [5, 10], [16, 20] [25, 26] [28, 30]
2nd set: [1, 5], [11, 12], [14, 18] [20, 23]

AND Result: [1, 2], [5, 5], [16, 18], [20, 20]

OR 

1st set: [0, 2], [6, 8], [16, 20]
2nd set: [1, 5], [12, 18], [20, 23]

[0,8], [12,23]
*/


//[0, 2] [4, 10]
//[1, 5] [8, 12]

//output : [1,2] [4, 5] [8, 10]

import java.util.List;
import java.util.ArrayList;
class Interval {
 int start, end;
 public Interval(int s, int e) {
     start = s;
     end = e;
 }
 public String toString() {
     return "[" + start + "," + end + "]";
 }
}

public class AndOrIntervals {
 
 public List<Interval> orIntervals(List<Interval> l1, List<Interval> l2) {
     List<Interval> res = new ArrayList<>();
     if (l1 == null || l1.size() == 0) return l2;
     if (l2 == null || l2.size() == 0) return l1;
     int i = 0, j = 0;
     while (i < l1.size() && j < l2.size()) {
         int start = Math.min(l1.get(i).start, l2.get(j).start);
         int end = Math.max(l1.get(i).end, l2.get(j).end);
         while ((i + 1 < l1.size() && l1.get(i + 1).start <= end + 1) || (j + 1 < l2.size() && l2.get(j + 1).start <= end + 1)) {
             if (i + 1 < l1.size() && l1.get(i + 1).start <= end + 1) {
                 end = Math.max(end, l1.get(++i).end);
             } else {
                 end = Math.max(end, l2.get(++j).end);
             }
         }
         res.add(new Interval(start, end));
         i++;
         j++;
     }
     return res;
 }
 
 public List<Interval> andIntervals(List<Interval> l1, List<Interval> l2) {
     List<Interval> res = new ArrayList<>();
     if (l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0) return res;
     int i = 0, j = 0;
     while (i < l1.size() && j < l2.size()) {
         int start = Math.max(l1.get(i).start, l2.get(j).start);
         int end = Math.min(l1.get(i).end, l2.get(j).end);
         res.add(new Interval(start, end));
         if (l1.get(i).end < l2.get(j).end) {
             i++;
         } else {
             j++;
         }
     }
     return res;
 }
 
 public static void main(String[] args) {
     AndOrIntervals solution = new AndOrIntervals();
     List<Interval> l1 = new ArrayList<>();
     l1.add(new Interval(0, 2));
     l1.add(new Interval(6, 8));
     l1.add(new Interval(16, 20));
     List<Interval> l2 = new ArrayList<>();
     l2.add(new Interval(1, 5));
     l2.add(new Interval(12, 18));
     l2.add(new Interval(20, 23));
     List<Interval> res = solution.orIntervals(l1, l2);
     for (Interval interval : res) {
         System.out.println(interval.toString());
     }
 }
}