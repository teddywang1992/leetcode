package ebay;

public class PowerThree {
    public boolean isPowerOfThree(int n) {
        if (n > 0) {
            if (n == 1) return true;
            return n % 3 == 0 && isPowerOfThree(n / 3);
        }

        return false;
    }
}
