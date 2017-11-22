package no484_FindpPermutation;

public class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) res[i] = i + 1; // sorted
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int l = i;
                while (i < s.length() && s.charAt(i) == 'D') i++;
                reverse(res, l, i);
            }
        }
        return res;
    }
    
    private void reverse(int[] res, int l, int h) {
        while (l < h) {
            int temp = res[l];
            res[l] = res[h];
            res[h] = temp;
            l++;
            h--;
        }
    }
}