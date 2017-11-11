package facebook1;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber1 {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        for (char c : digits.toCharArray()) {
            int digit = c - '0';
            List<String> list = new ArrayList<>();
            if (digit <= 1) continue;
            for (char c1 : map[digit].toCharArray()) {
                for (String s : result) {
                    list.add(s + c1);
                }
            }
            result = list;
        }

        return result;
    }
}
