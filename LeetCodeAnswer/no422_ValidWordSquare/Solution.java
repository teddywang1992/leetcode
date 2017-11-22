package no422_ValidWordSquare;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        if (words.get(0).length() != words.size()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (i != 0) {
                if (words.get(i).length() > words.get(i - 1).length()) return false;
            }
            for (int j = 0; j < words.get(i).length(); j++) {
                if (words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        return true;
    }
}