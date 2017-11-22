package LeetCodeAnswer.no284_PeekingIterator;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {
 
	private Iterator<Integer> iterator;
	private Integer cache;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     if (cache == null && iterator.hasNext()) cache = iterator.next();
     return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    Integer tmp = peek();
	    cache = null;
	    return tmp;
	}

	public boolean hasNext() {
	    return peek() != null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}