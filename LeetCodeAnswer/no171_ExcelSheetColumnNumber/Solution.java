package no171_ExcelSheetColumnNumber;

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.length() == 0) return result;
        for (char c: s.toCharArray()) {
            result = result * 26 + c - 'A' + 1;
        }
        return result;
    }
}