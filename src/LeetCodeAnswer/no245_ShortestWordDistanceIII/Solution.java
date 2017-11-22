package LeetCodeAnswer.no245_ShortestWordDistanceIII;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 >= 0) res = Math.min(res, i - index2);
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) index1 = index2;
                index2 = i;
                if (index1 >= 0) res = Math.min(res, i - index1);
            }
        }
        return res;
    }
}
