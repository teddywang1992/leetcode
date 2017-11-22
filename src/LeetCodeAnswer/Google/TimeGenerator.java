package LeetCodeAnswer.Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimeGenerator {
	public String nextTime(String time) {
		Set<Character> dict = new HashSet<>();
		String formattedTime = time.substring(0, 2) + time.substring(3);
		int startTime = convert(formattedTime);
		for (char c : formattedTime.toCharArray()) {
			dict.add(c);
		}
		if (dict.size() == 1) return time;
		List<String> candidate = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(candidate, dict, sb);
		String res = "", lateRes = "";
		int before = 0, after = Integer.MAX_VALUE;
		for (String str : candidate) {
			int diff = convert(str) - startTime;
			if (diff > 0 && diff < after) {
				after = diff;
				lateRes = str;
			}
			if (diff < 0 && diff < before) {
				before = diff;
				res = str;
			}
		}
		if (after != Integer.MAX_VALUE) res = lateRes;
		return res.substring(0, 2) + ":" + res.substring(2);
	}

	public void dfs(List<String> res, Set<Character> dict, StringBuilder sb) {
		if (sb.length() == 4) {
			if (isValid(sb))
				res.add(sb.toString());
			return;
		}
		for (char c : dict) {
			sb.append(c);
			dfs(res, dict, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private int convert(String str) {
		return 60 * ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0')
				+ (str.charAt(2) - '0') * 10 + str.charAt(3) - '0';
	}

	public boolean isValid(StringBuilder sb) {
		int hour = (sb.charAt(0) - '0') * 10 + sb.charAt(1) - '0';
		int min = (sb.charAt(2) - '0') * 10 + sb.charAt(3) - '0';
		return hour < 24 && min < 60;
	}

	public static void main(String[] args) {
		TimeGenerator timeGenerator = new TimeGenerator();
		System.out.println(timeGenerator.nextTime("22:55"));
	}
}
