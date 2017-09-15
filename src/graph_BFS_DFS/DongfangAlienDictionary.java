package graph_BFS_DFS;

import java.util.*;

public class DongfangAlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            if(words == null || words.length == 0){
                return "";
            }

            Map<Character, Integer> indegreeMap = new HashMap<>();
            Map<Character, Set<Character>> orderMap = new HashMap<>();
            Queue<Character> q = new LinkedList<>();

            for(String w: words){
                for(char c: w.toCharArray()){
                    indegreeMap.put(c, 0);
                }
            }

            for(int i = 0; i + 1 < words.length; i++){
                String s1 = words[i], s2 = words[i + 1];
                int n1 = s1.length(), n2 = s2.length(), len = Math.min(n1, n2);
                for(int j = 0; j < len; j++){
                    char c1 = s1.charAt(j), c2 = s2.charAt(j);
                    if(c1 != c2){
                        orderMap.putIfAbsent(c1, new HashSet<>());
                        if(!orderMap.get(c1).contains(c2)){
                            orderMap.get(c1).add(c2);
                            indegreeMap.put(c2, indegreeMap.getOrDefault(c2, 0) + 1);
                        }
                        break;
                    }

                }
            }

            for(Character c: indegreeMap.keySet()){
                if(indegreeMap.get(c) == 0){
                    q.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!q.isEmpty()){
                char c1 = q.poll();
                sb.append(c1);
                if(orderMap.containsKey(c1)){
                    for(char c2: orderMap.get(c1)){
                        indegreeMap.put(c2, indegreeMap.get(c2) - 1);
                        if(indegreeMap.get(c2) == 0){
                            q.add(c2);
                        }
                    }
                }
            }

            return sb.length() == indegreeMap.size()? sb.toString(): "";
        }
    }
}
