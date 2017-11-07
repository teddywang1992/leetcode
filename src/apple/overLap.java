package apple;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *

Hi Henry here!

|----------------->
A  2|---|5 7|-----|10
B.    4|--|6         12|----|15

A=[(2,5),(7,10)]
B=[(4,6),(12,15)]


A 2|----------------|10 12|----|15
B.     4|-|5 6|-|7

A[i].lower < A[i].upper
A[i].upper < A[i+1].lower

-> [(0,0)]

 * If you need more classes, simply define them inline.
 */

class Interval {
    int lower;
    int upper;
    public Interval (int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
}

class overLap {
    public static void main(String[] args) {
        Interval i1 = new Interval(4,5);
        Interval i2 = new Interval(6,7);
        Interval i3 = new Interval(2,10);
        Interval i4 = new Interval(12,15);
        List<Interval> a = new ArrayList<>();
        a.add(i1);
        a.add(i2);
        List<Interval> b = new ArrayList<>();
        b.add(i3);
        b.add(i4);
        List<Interval> res = overlaps(a, b);
        for (Interval i : res) {
            System.out.println("lower: " + i.lower);
            System.out.println("upper: " + i.upper);
        }

    }

    // a: [2,5], b: [3,4]
    // a: [4,5], b: [2,3]


    public static List<Interval> overlaps(List<Interval> a, List<Interval> b) {
        List<Interval> res = new ArrayList<Interval>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).upper >= b.get(j).lower && a.get(i).lower <= b.get(j).upper) {
                Interval tmp = new Interval(i, j);
                res.add(tmp);
                if (j + 1 < b.size() && a.get(i).upper >= b.get(j + 1).lower) {
                    j++;
                } else {
                    i++;
                }
            } else {
                if (b.get(j).lower < a.get(i).lower) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}

