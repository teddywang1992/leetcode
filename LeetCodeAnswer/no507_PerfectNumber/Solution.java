package no507_PerfectNumber;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;
        int sum = 0, val = num;
        for (int i = 1; i < val; i++) {
            if (num % i == 0) {
                if (i == 1) sum += i;
                else {
                    sum += i;
                    sum += num /i;
                }
                val = num / i;
            }
        }
        
        return sum == num;
    }
}