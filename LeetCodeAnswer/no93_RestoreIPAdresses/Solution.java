package no93_RestoreIPAdresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4)
            return res;
        StringBuilder sb = new StringBuilder();
        DFS(res, s, sb, -1, 0, 0);
        return res;
    }
    
    private void DFS(List<String> res, String s, StringBuilder sb, int num, int index, int dotCount) {
        if (index == s.length()) {
            if (dotCount == 3) {
                sb.append(num);
                res.add(sb.toString());
                if (num == 0)
                    sb.setLength(sb.length() - 1);
                else
                    sb.setLength(sb.length() - (int) (Math.log10(num) + 1));
            }
            return;
        }
    
        int digit = Character.digit(s.charAt(index), 10);
        //continue adding digits
        if ((num != 0 && num * 10 + digit <= 255) || num == -1)
            DFS(res, s, sb, (num == -1 ? 0 : num) * 10 + digit, index + 1, dotCount);
            
        //stop adding digits
        if (num >= 0 && dotCount < 3) {
            sb.append(num).append('.');
            DFS(res, s, sb, digit, index + 1, dotCount + 1);
            if (num == 0)
                sb.setLength(sb.length() - 2);
            else
                sb.setLength(sb.length() - 1 - (int)(Math.log10(num) + 1));
        }
    }
}