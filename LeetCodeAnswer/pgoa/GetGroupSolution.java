package pgoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetGroupSolution {
	static int[] getTheGroups(int n, String[] queryType, int[] students1, int[] students2) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(i);
			map.put(i, set);
		}
		for (int i = 0; i < queryType.length; i++) {
			if (queryType[i].equals("Friend")) {
				map.get(students1[i]).add(students2[i]);
				map.get(students2[i]).add(students1[i]);
			} else {
				Set<Integer> tmp = new HashSet<>();
				tmp.addAll(map.get(students1[i]));
				tmp.addAll(map.get(students2[i]));
				res.add(tmp.size());
			}
		}
		
		int[] arr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
		return arr;
	}
}
