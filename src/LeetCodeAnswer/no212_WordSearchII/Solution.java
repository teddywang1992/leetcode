package LeetCodeAnswer.no212_WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    class Trie {

        /** Initialize your data structure here. */
        class TrieNode {
            char c;
            boolean end;
            TrieNode[] nodes;
            public TrieNode() {
                c = ' ';
                end = false;
                nodes = new TrieNode[26];
            }

            public TrieNode(char c) {
                this();
                this.c = c;
            }
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TrieNode(c);
                }
                node = node.nodes[c - 'a'];
            }
            node.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || word.length() == 0) return true;
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) return false;
                node = node.nodes[c - 'a'];
            }
            return node.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return true;
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.nodes[c - 'a'] == null) return false;
                node = node.nodes[c - 'a'];
            }
            return true;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        HashSet<String> res = new HashSet<String>();
        for (String word : words) {
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, board, "", i, j, trie);
            }
        }
        
        return new ArrayList<String>(res);
    }
    
    public void dfs(HashSet<String> res, char[][] board, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (board[x][y] == '*') return;
        
        str += board[x][y];
        if (!trie.startsWith(str)) return;
        
        if (trie.search(str)) {
            res.add(str);
        }
        
        char temp = board[x][y];
        board[x][y] = '*';
        dfs(res, board, str, x - 1, y, trie);
        dfs(res, board, str, x + 1, y, trie);
        dfs(res, board, str, x, y - 1, trie);
        dfs(res, board, str, x, y + 1, trie);
        board[x][y] = temp;
    }
}