package Houzz;

public class Solution {
	public double validNumber(String num) {
		if (num == null || num.length() == 0) throw new IllegalArgumentException();
		int len = num.length(), index = 0, afterPointLen = 0;
		double beforePoint = 0, afterPoint = 0;
		boolean pointShown = false, digitShown = false, isPositive = true, signShown = false;
		while (index < len && num.charAt(index) == ' ') index++;
		while (index < len) {
			char c = num.charAt(index);
			if (Character.isDigit(c)) {
				if (pointShown) {
					afterPointLen++;
					afterPoint = afterPoint + (c - '0') / Math.pow(10, afterPointLen);
				} else {
					beforePoint = beforePoint * 10 + c - '0';
				}
				digitShown = true;
				index++;
				continue;
			}
			if (c == '+' || c == '-') {
				if (digitShown || pointShown || signShown) throw new IllegalArgumentException();
				if (c == '-') isPositive = false;
				signShown = true;
				index++;
				continue;
			}
			if (c == '.') {
				if (pointShown) throw new IllegalArgumentException();
				pointShown = true;
				index++;
				continue;
			}
			if (c == ' ') {
				break;
			}
			throw new IllegalArgumentException();
		}
		while (index < len && num.charAt(index) == ' ') index++;
		if (index != len) throw new IllegalArgumentException();
		return (beforePoint + afterPoint) * (isPositive ? 1 : -1);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.validNumber("-1.3458"));
	}
}
