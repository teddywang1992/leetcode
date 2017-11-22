package LeetCodeAnswer.no500_KeyBoardRow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] findWords(String[] words) {
        // O(n)
        String[] base = {"qwertyuiop","asdfghjkl","zxcvbnm"};
    	List<String> list = new ArrayList<String>();
    	for (String string : words) {
    		for (String basStr : base) {
    			boolean find = true;
    			for (char c : string.toCharArray()) {
    				String low = String.valueOf(c).toLowerCase();
    				if (!basStr.contains(low)){
    					find = false;
    					break;
    				}
    			}
    			if (find) list.add(string);
    		}
    	}
    	String[] res = new String[list.size()];
    	for (int i = 0; i < res.length; i++) res[i] = list.get(i);
    	return res;
    }
}