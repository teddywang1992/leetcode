package no179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] trans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) trans[i] = String.valueOf(nums[i]);
        
        Comparator<String> comp = new Comparator<String>(){
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			    String s2 = str2 + str1;
			    return s2.compareTo(s1);
		    }
	    };
	    
        Arrays.sort(trans, comp);
        String result ="";
        for (String s: trans) {
            result += s;
        }
        if (result.charAt(0) == '0') return "0";
        return result;
    }
}