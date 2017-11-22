package LeetCodeAnswer.no170_TwoSum3_DataStructureDesign;

import java.util.HashMap;

public class TwoSum {

    // Add the number to an internal data structure.
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int key: map.keySet()) {
	        if (map.containsKey(value - key)) {
	            if ((value - key) != key) return true;
	            if (map.get(key) >= 2) return true;
	        }
	    }
	    return false;
	}
	
//    Set<Integer> sum;
//    Set<Integer> num;
//    
//    TwoSum(){
//        sum = new HashSet<Integer>();
//        num = new HashSet<Integer>();
//    }
//    // Add the number to an internal data structure.
//	public void add(int number) {
//	    if(num.contains(number)){
//	        sum.add(number * 2);
//	    }else{
//	        Iterator<Integer> iter = num.iterator();
//	        while(iter.hasNext()){
//	            sum.add(iter.next() + number);
//	        }
//	        num.add(number);
//	    }
//	}
//
//    // Find if there exists any pair of numbers which sum is equal to the value.
//	public boolean find(int value) {
//	    return sum.contains(value);
//	}
}

