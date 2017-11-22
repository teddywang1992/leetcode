package no667_BeautifulArrangementII;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n, i = 0;
        while (left <= right) {
            if (k > 1) {
                if (k % 2 != 0) {
                    res[i++] = left++;
                } else {
                    res[i++] = right--;
                }
                k--;
            } else {
                res[i++] = left++;
            }
        }
        return res;
    }
}