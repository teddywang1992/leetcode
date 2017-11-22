package no258_AddDigits;

public class Solution {
    public int addDigits(int num) {
        // if (num < 10) return num;
        // int res = 0;
        // while (num != 0) {
        //     res += num % 10;
        //     num /= 10;
        // }
        // return addDigits(res);
        
        // 10^k % 9 = 1
        // a*10^k % 9 = a % 9 
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}