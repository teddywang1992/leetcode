package binarySearch;

public class sqrt {
    public static void main(String[] args) {
        sqrt obj = new sqrt();
        System.out.println(obj.mySqrt(188888888));
    }
    private int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int)end;
        }
        else {
            return (int)start;
        }
    }
}
