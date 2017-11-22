package no202_HappyNumber;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            n = getHappy(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }
    
    private int getHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
		System.out.println("".split(",").length);
	}
}