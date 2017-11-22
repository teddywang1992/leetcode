package LeetCodeAnswer.no342_PowerOfFour;

public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && Math.pow(4, 15) % num == 0 && (num & 0x55555555) == num;
    }
}