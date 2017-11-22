package LeetCodeAnswer.no520_DetectCapital;

public class Solution {
	public boolean detectCapitalUse(String word) {
		// return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");

		// return word.equals(word.toUpperCase()) ||
		// word.equals(word.toLowerCase()) ||
		// Character.isUpperCase(word.charAt(0)) &&
		// word.substring(1).equals(word.substring(1).toLowerCase());

		// int numUpper = 0;
		// for (int i=0;i<word.length();i++) {
		// if (Character.isUpperCase(word.charAt(i))) numUpper++;
		// }
		// if (numUpper == 0 || numUpper == word.length()) return true;
		// if (numUpper == 1) return Character.isUpperCase(word.charAt(0));
		// return false;

		if (word == null || word.length() < 2)
			return true;
		boolean upper = Character.isUpperCase(word.charAt(0))
				&& Character.isUpperCase(word.charAt(1));
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (upper) {
				if (!Character.isUpperCase(c))
					return false;
			} else {
				if (Character.isUpperCase(c))
					return false;
			}
		}
		return true;
	}
}