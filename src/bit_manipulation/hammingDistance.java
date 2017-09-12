package bit_manipulation;

public class hammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
    private static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }

        return count;
    }
}
