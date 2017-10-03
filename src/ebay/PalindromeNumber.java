package ebay;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x1 = 121;
        int x2 = 1221;
        int x3 = 10;

        System.out.println(isPalindrome(x3));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) { // when the value is less than 0 and the input is like 10 20 100
            return false;
        }

        int result = 0;

        while (x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return x == result || x == result / 10;
    }
}
