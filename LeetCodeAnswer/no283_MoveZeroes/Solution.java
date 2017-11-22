package no283_MoveZeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;        
        int p1 = 0, p2 = 0;
        while (p1 < nums.length) {
            while (p2 < nums.length && nums[p2] != 0) p2++;
            while (p1 < nums.length && (nums[p1] == 0 || p1 < p2)) p1++;
            if (p1 == nums.length) return;
            nums[p2++] = nums[p1];
            nums[p1++] = 0;
        }
    }
    
    public List<String> rotated (int num) {
    	List<String> res = new ArrayList<>();
    	if (num == 0) return res;
    	if (num == 1) return Arrays.asList("0", "1", "8");
    	if (num == 2) return Arrays.asList("00", "11", "88", "69", "96");
    	if (num % 2 == 0) {
    		dfs(res, num, "00");
    		dfs(res, num, "11");
    		dfs(res, num, "88");
    		dfs(res, num, "69");
    		dfs(res, num, "96");
    	} else {
    		dfs(res, num, "0");
    		dfs(res, num, "1");
    		dfs(res, num, "8");
    	}
    	return res;
    }
    private void dfs(List<String> res, int num, String str) {
    	if (str.length() == num) {
    		res.add(str);
    		return;
    	}
    	dfs(res, num, "0" + str + "0");
    	dfs(res, num, "1" + str + "1");
    	dfs(res, num, "6" + str + "9");
    	dfs(res, num, "9" + str + "6");
    	dfs(res, num, "8" + str + "8");
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rotated(3));
	}
}