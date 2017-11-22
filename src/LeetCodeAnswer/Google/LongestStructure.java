package LeetCodeAnswer.Google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestStructure {
	public static String getLongestWord(List<String> word) {
		Queue<String> queue = new LinkedList<>();
		for (String w : word) {
			if (w.length() == 1) {
				queue.offer(w);
			}
		}
		String res = "";
		while (!queue.isEmpty()) {
			res = queue.peek();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				for (String next : word) {
					if (valid(str, next)) {
						queue.offer(next);
					}
				}
			}
		}
		return res;
	}

	public static boolean valid(String str, String next) {
		if (str.length() + 1 != next.length())
			return false;
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) != next.charAt(i))
				return next.substring(i + 1).equals(str.substring(i));
		}
		return i == str.length();
	}

	public static void main(String[] args) {
		System.out.println(getLongestWord(Arrays.asList("a",
				"ab", "abc")));
	}
}
