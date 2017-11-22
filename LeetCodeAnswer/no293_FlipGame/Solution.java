package no293_FlipGame;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> rs = new ArrayList<String>();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String ss = s.substring(0, i) + "--" + s.substring(i + 2);
                rs.add(ss);
            }
        }
        return rs;
    }
}