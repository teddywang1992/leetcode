package facebook2;

import java.util.*;

public class TopKRequent {
    TrieNode root = null;
    public List<String> topKFrequent(String[] words, int k) {
        root = new TrieNode(26);
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word,map.getOrDefault(word,0)+1);
        for(String word: map.keySet()) {
            int count = map.get(word);
            if(root.Children[count]==null) root.Children[count] = new TrieNode(26);
            insertWord(root.Children[count], word);
        }
        List<String> result = new LinkedList<>();
        for(int i = 25; i>=0; i--){
            if(root.Children[i]!=null)
                addWord(root.Children[i], k, result);
        }
        return result;
    }
    public void insertWord(TrieNode node, String word){
        for(int i = 0; i<word.length()&&node!=null; i++){
            char c = word.charAt(i);
            if(node.Children[c-'a']==null) node.Children[c-'a'] = new TrieNode(26);
            node = node.Children[c-'a'];
        }
        node.isWord = true;
        node.Word = word;
    }
    public void addWord(TrieNode node, int k, List<String> result){
        if(node.isWord&&result.size()<k) {
            result.add(node.Word);
            if(result.size()==k) return;
        }
        for(int i = 0; i<26; i++){
            if(node.Children[i]!=null)
                addWord(node.Children[i], k, result);
        }
    }
}
class TrieNode{
    TrieNode[] Children;
    boolean isWord;
    String Word;
    TrieNode(int size){
        Children = new TrieNode[size];
    }
}
