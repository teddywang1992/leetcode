package facebook1;

public class sqrtX {
    public int mySqrt(int x) {
        long start = 1;
        long end = x; // x = 1;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }

        else return (int) start;
    }
}
