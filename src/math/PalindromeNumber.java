package math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) { // when the value is less than 0 and the input is like 10 20 100
            return false;
        }

        int result = 0;

        while (x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result == x || x == result / 10;
    }
}
