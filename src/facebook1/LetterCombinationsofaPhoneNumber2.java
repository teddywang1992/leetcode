package facebook1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsofaPhoneNumber2 {
    String[] map = new String[]{"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(result, digits, 0, "");
        return result;
    }

    private void dfs(List<String> result, String digits, int pos, String cur) {
        if (pos == digits.length()) {
            result.add(cur);
            return;
        }
        int digit = digits.charAt(pos) - '0';
        if (digit <= 1) return;
        for (char c : map[digit].toCharArray()) {
            dfs(result, digits, pos + 1, cur + c);
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits == null | digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("");
        Queue<String> queue = new LinkedList<>();
        String[] map = new String[]{"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char c : digits.toCharArray()) {
            int digit = c - '0';
            if (digit <= 1) continue;
            List<String> temp = new ArrayList<>();
            for (char c1 : map[digit].toCharArray()) {
                for (String s : result) {
                    temp.add(s+c1);
                }
            }
            result = temp;
        }
        return result;
    }
}
