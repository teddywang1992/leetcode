package LeetCodeAnswer.no441_ArrangingCoins;

public class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        while (n >= (count + 1)) {
        	count++;
        	n -= count;
        }
        return count;
    }
}
