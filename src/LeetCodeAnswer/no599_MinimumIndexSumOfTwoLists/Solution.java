package LeetCodeAnswer.no599_MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		// O(l1 * l2 * x)
		// HashMap < Integer, List < String >> map = new HashMap < > ();
		// for (int i = 0; i < list1.length; i++) {
		// for (int j = 0; j < list2.length; j++) {
		// if (list1[i].equals(list2[j])) {
		// if (!map.containsKey(i + j))
		// map.put(i + j, new ArrayList < String > ());
		// map.get(i + j).add(list1[i]);
		// }
		// }
		// }
		// int min_index_sum = Integer.MAX_VALUE;
		// for (int key: map.keySet())
		// min_index_sum = Math.min(min_index_sum, key);
		// String[] res = new String[map.get(min_index_sum).size()];
		// return map.get(min_index_sum).toArray(res);

		// O(l1 + l2), O(l1 * x)
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++)
			map.put(list1[i], i);
		List<String> res = new ArrayList<String>();
		int min_sum = Integer.MAX_VALUE, sum;
		for (int j = 0; j < list2.length; j++) {
			if (map.containsKey(list2[j])) {
				sum = j + map.get(list2[j]);
				if (sum < min_sum) {
					res.clear();
					res.add(list2[j]);
					min_sum = sum;
				} else if (sum == min_sum)
					res.add(list2[j]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
}