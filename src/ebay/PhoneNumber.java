package ebay;

import java.util.LinkedList;
import java.util.List;

//leetcode phone keyboard

public class PhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");

        for (int i = 0; i < digits.length(); i++) {
            while (queue.peek().length() == i) {
                String temp = queue.poll();
                for (char c : map[Character.getNumericValue(digits.charAt(i))].toCharArray()) {
                    queue.offer(temp + c);
                }
            }
        }

        return queue;
    }
}
