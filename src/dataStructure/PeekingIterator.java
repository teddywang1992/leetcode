package dataStructure;

import java.util.Iterator;

public class PeekingIterator {
    private Iterator<Integer> iterator;
    private Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        next = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        int result = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    public boolean hasNext() {
        return next != null;
    }
}
