package no343_IntegerBreak;

public class Solution {
    public int integerBreak(int n) {
        if (n < 3)
			return 1;
		if (n == 3)
			return 2;
		if (n % 3 == 0)
			return (int) Math.pow(3, n / 3);
		if (n % 3 == 1)
			return 2 * 2 * ((int) Math.pow(3, (n - 4) / 3));

		return 2 * ((int) Math.pow(3, (n - 2) / 3));
    }
}