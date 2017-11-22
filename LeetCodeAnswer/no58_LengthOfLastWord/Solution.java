package no58_LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        // String[] strs = s.trim().split("\\s+");
        // return strs[strs.length - 1].length();
        int len = 0;
        int i = s.length()-1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (len > 0) { 
                    return len;
                }
            } else {
                len++;
            }
            
            i--;
        }
        
        return len;   // corner case: "a"
    }
}