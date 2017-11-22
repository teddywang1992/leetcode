package no438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (p.length() > s.length()) return result;
        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) charCounts[c - 'a']++;
        int left = 0, right = 0, numDiff = p.length();
        for (right = 0; right < p.length(); right++) {
            char c = s.charAt(right);
            if (charCounts[c - 'a'] > 0) numDiff--;
            charCounts[c - 'a']--;
        }
        if (numDiff == 0) result.add(0);
        
        while (right < s.length()) {
            char leftChar = s.charAt(left++);
            if (charCounts[leftChar - 'a'] == 0) numDiff++;
            charCounts[leftChar - 'a']++;
            
            char rightChar = s.charAt(right++);
            charCounts[rightChar - 'a']--;
            
            if (charCounts[rightChar - 'a'] == 0) numDiff--;
            if (numDiff == 0) result.add(left);
        }
        return result;
    }
}
