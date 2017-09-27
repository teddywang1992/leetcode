package string;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String temp = result.remove();
                for (char c : map[index].toCharArray()) {
                    result.add(temp + c);
                }
            }
        }

        return result;
    }
}
