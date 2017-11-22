package no246_StrobogrammaticNumber;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char lc = num.charAt(left), rc = num.charAt(right);
            if (lc != rc) {
                if ((lc == '9' && rc == '6') || (lc == '6' && rc == '9')) {
                    left++;
                    right--;
                    continue;
                } else {
                    return false;
                }
            }
            if (lc == '1' || lc == '8' || lc == '0') {
                left++;
                right--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}