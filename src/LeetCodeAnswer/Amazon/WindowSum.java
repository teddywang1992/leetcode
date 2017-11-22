package LeetCodeAnswer.Amazon;

import java.util.*;

public class WindowSum {
	public static List<Integer> windowSum(List<Integer> input, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (input == null || input.size() == 0 || k <= 0)
			return res;
		if (k >= input.size()) {
			int sum = 0;
			for (int i : input)
				sum += i;
			res.add(sum);
			return res;
		} else {
			int sum = 0;
			for (int i = 0; i < input.size(); i++) {
				sum += input.get(i);
				if (i >= k)
					sum -= input.get(i - k);
				if (i >= k - 1)
					res.add(sum);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> input = new ArrayList<Integer>();
		input.addAll(Arrays.asList(2, 3, 4, 2, 5, 7, 8, 9, 6));
		// List<Integer> input1 = new ArrayList<>();
		// input1.addAll(Arrays.asList(1,2));
		List<Integer> output = windowSum(input, 4);
		for (int i : output)
			System.out.print(i + " ");
	}

}