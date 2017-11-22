package no187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if( s==null || s.length() <= 10) {
            return result;
        }

        //Define a memo to store each 10 letter-long sub-strings.
        HashSet<String> set = new HashSet<String>();
        HashSet<String> dupSet = new HashSet<String>();

        char[] chars = s.toCharArray();

        for(int i=0; i<= chars.length - 10; i++){
            String str = new String(chars, i, 10);
            if(set.contains(str)) {
                dupSet.add(str);
            } else{
                set.add(str);
            }
        }

        result.addAll(dupSet);
        return result;
    }
}