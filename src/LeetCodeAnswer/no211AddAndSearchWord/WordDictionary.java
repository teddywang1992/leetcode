	package LeetCodeAnswer.no211AddAndSearchWord;

class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        char c;
        boolean end;
        TrieNode[] nodes;
        public TrieNode() {
            c = ' ';
            nodes = new TrieNode[26];
        }
        public TrieNode(char c) {
            this();
            this.c = c;
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) node.nodes[c - 'a'] = new TrieNode(c);
            node = node.nodes[c - 'a'];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return search(word.toCharArray(), root, 0);
    }
    
    private boolean search(char[] chars, TrieNode root, int index) {
        TrieNode node = root;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '.') {
                for (char chr = 'a'; chr <= 'z'; chr++) {
                    TrieNode temp = node.nodes[chr - 'a'];
                    if (temp == null) continue;
                    if (search(chars, temp, i + 1)) return true;
                }
                return false;
            } else {
                if (node.nodes[chars[i] - 'a'] == null) return false;
            }
            node = node.nodes[chars[i] - 'a'];
        }
        return node.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */