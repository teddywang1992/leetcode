package no50_pow;

public class Solution {
	public double myPow(double x, int n) {
		// base case
		if (n == 0) {
			return 1;
		}
		// handle negative situation
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				double temp = myPow(x, -(n / 2)); // Integer.MIN_VALUE is an
													// even number
				return 1 / (temp * temp);
			} // else
			return 1 / myPow(x, -n);
		}
		// general situation
		double temp = myPow(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} // else
		return x * temp * temp;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.myPow(1.1, Integer.MIN_VALUE));

	}

}
