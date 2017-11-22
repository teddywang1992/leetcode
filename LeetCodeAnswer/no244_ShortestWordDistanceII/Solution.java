package no244_ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    
    private HashMap<String, ArrayList<Integer>> map;
    
    public Solution(String[] words) {
        map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(w, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int result = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if (index1 < index2) {
                result = Math.min(result, index2 - index1);
                i++;
            } else {
            	if (index1 == index2) {
            		j++;
            		continue;
            	}
                result = Math.min(result, index1 - index2);
                j++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		System.out.println(solution.shortest("makes", "makes"));
	}
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");