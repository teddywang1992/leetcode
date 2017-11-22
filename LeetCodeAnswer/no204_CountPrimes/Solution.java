package no204_CountPrimes;

public class Solution {
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) continue;
            count++;
            
            for (int j = i; j < n; j += i) flag[j] = true;
        }
        return count;
    }
}
