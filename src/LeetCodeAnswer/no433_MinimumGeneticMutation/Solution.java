package LeetCodeAnswer.no433_MinimumGeneticMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Container {
    String word;
    int steps;
    public Container(String word,int steps) {
        this.word=word;
        this.steps=steps;
    }
}

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<String>();
        char[] chars = {'A','C','G','T'};
        for(String b : bank) set.add(b);
        if(!set.contains(end))return -1;
        Queue<Container> q=new LinkedList<Container>();
        q.add(new Container(start,0));
        
        while (!q.isEmpty()) {
            Container con=q.poll();
            char[] str=con.word.toCharArray();
            for(int i=0;i<str.length;i++) {
                char tmpChar=str[i];
                for(char c:chars) {
                    if(c == str[i]) continue;
                    str[i]=c;
                    String tmpStr=new String(str);
                    if(tmpStr.equals(end)) return con.steps+1;
                    if(set.contains(tmpStr))  q.add(new Container(tmpStr,con.steps+1));
                }
                str[i]=tmpChar;
            }
        }
        return -1;
    }
}