package LeetCodeAnswer.no347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pque = 
            new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {

				public int compare(Entry<Integer, Integer> o1,
						Entry<Integer, Integer> o2) {
					return o1.getValue() - o2.getValue();
				}
			});
        pque.addAll(map.entrySet());
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            ret.add(pque.poll().getKey());
        }
        return ret;
    }
}
