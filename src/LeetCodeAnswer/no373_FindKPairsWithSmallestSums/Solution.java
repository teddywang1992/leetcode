package LeetCodeAnswer.no373_FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();

        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> que = new PriorityQueue<int[]>(k, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] + o1[1] - o2[0] - o2[1];
			}
        	
		});
        
        // runs min(k, nums1.length) times -> 1, log2, log2, log3 ... logk
        for(int i = 0; i < Math.min(nums1.length, k); i++)
            que.offer(new int[]{nums1[i], nums2[0], 0});
        
        // runs k times -> logk, logk, logk ...
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll(); // pop the min
            result.add(new int[]{ cur[0], cur[1] }); // add the first 2 columns of min to result
            
            if (cur[2] == nums2.length-1) continue; // if (nums2Index == end of nums2) then continue
            
            int currNums1Val = cur[0];
            int nextNums2Index = cur[2] + 1;
            int nextNums2Value = nums2[nextNums2Index];
            
            que.offer(new int[]{ currNums1Val, nextNums2Value, nextNums2Index });
        }
        
        return result;
    }
}
