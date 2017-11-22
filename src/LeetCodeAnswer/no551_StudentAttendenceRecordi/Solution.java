package LeetCodeAnswer.no551_StudentAttendenceRecordi;

public class Solution {
    public boolean checkRecord(String s) {
        int numA = 0;
        int numL = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'A') {
                numA++;
                numL = 0;
                if (numA > 1) return false;
            } else if (c == 'L') {
                numL++;
                if (numL > 2) return false;
            } else {
                numL = 0;
            }
        }
        return true;
    }
}