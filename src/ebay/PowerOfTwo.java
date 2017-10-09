package ebay;

public class PowerOfTwo {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(num & 1);
    }

    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }

        return count == 1;
    }
}
