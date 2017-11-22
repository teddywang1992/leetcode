package LeetCodeAnswer.no205_IsomorphicStrings;

import java.util.HashMap;

public class Solution {
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (Integer i = 0; i < s.length(); i++) {
        	// put 操作返回之前的value
            if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) { 
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.print(solution.isIsomorphic("hahahahaha","lalalalala"));

	}

}
