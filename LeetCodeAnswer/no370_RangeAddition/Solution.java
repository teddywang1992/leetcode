package no370_RangeAddition;

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // int[] res = new int[length];
        // if (updates == null || updates.length == 0) return res;
        // for (int i = 0; i < updates.length; i++) {
        //     for (int j = updates[i][0]; j <= updates[i][1]; j++) {
        //         res[j] += updates[i][2];
        //     }
        // }
        // return res;
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end < length - 1) res[end + 1] -= value;
        }
    
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
    
        return res;
    }
}