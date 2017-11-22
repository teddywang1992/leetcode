package LeetCodeAnswer.no266_PalindromePermutation;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        // int count = 0;
        // boolean[] chars = new boolean[256];
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     count = count + (chars[c] ? -1 : 1);
        //     chars[c] = !chars[c];
        // }
        // return count < 2;
        
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }
}
