package LeetCodeAnswer.no151_ReverseWordsInaString;

public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            sb.append(strs[i]).append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}