package facebook3;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long ldividend = (long) Math.abs(dividend), ldivisor = (long) Math.abs(divisor);
        int sign = (ldividend < 0) ^ (ldivisor < 0) ? -1 : 1;
        long result = 0;
        if (ldivisor == 0) return sign == 1 ? (int) ldividend : (int) -ldivisor;
        while (ldividend >= ldivisor) {
            long temp = ldivisor, p = 1;
            while (ldividend >= temp << 1) {
                temp <<= 1;
                p <<= 1;
            }
            result += p;
            ldividend -= temp;
        }
        return sign == 1 ? (int) result : (int) -result;
    }
}
