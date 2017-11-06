package facebook1;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        String[] map = new String[]{"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            while (result.peek().length() == i) {
                String cur = result.remove();
                for (char c : map[index].toCharArray()) {
                    result.add(cur + c);
                }
            }
        }

        return result;
    }
}
