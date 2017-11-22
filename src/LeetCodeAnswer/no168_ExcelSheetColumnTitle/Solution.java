package LeetCodeAnswer.no168_ExcelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            char c = (char)((n - 1) % 26 + 65);
            sb.append(c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}