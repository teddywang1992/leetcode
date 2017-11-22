package no295_FindMedianFromDataStream;

import java.util.PriorityQueue;

public class MedianFinder {

    // Adds a number into the data structure.
    PriorityQueue<Long> small = new PriorityQueue<Long>();
    PriorityQueue<Long> large = new PriorityQueue<Long>();
    
    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (large.peek() - small.peek()) / 2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
