package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        String temp = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
        String[] types = temp.split("\\|");
        System.out.println(types.length);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }

        return false;
    }
}
