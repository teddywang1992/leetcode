package LeetCodeAnswer.no434_NumberOfSegmentsInAString;

public class Solution {
    public int countSegments(String s) {
        String trim = s.trim();
        if (trim.length() == 0) return 0;
        return trim.split("\\s+").length;
    }
}