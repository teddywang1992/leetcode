package LeetCodeAnswer.no648_ReplaceWords;

import java.util.List;

class Solution {
    class TrieNode {
        boolean end;
        TrieNode[] nodes;
        public TrieNode() {
            nodes = new TrieNode[26];
            end = false;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split("\\s+");
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) node.nodes[c - 'a'] = new TrieNode();
                node = node.nodes[c - 'a'];
            }
            node.end = true;
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(getReplace(word, root)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private String getReplace(String word, TrieNode root) {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) return word;
            sb.append(c);
            node = node.nodes[c - 'a'];
            if (node.end) return sb.toString();
        }
        return word;
    }
}