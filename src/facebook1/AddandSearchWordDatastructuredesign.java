package facebook1;

public class AddandSearchWordDatastructuredesign {
    class Trie {
        Trie[] children;
        boolean isWord;
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
    Trie node;
    /** Initialize your data structure here. */
    public AddandSearchWordDatastructuredesign() {
        node = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) cur.children[index] = new Trie();
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie cur = node;
        if (find(word, cur, 0)) return true;
        return false;
    }

    public boolean find(String word, Trie node, int index) {
        if (index == word.length() && node.isWord) return true;
        if (index >= word.length()) return false;
        char c = word.charAt(index);
        if (c == '.') {
            for (Trie child : node.children) {
                if (child != null) if (find(word, child, index + 1)) return true;
            }
        }
        else {
            if (node.children[c - 'a'] == null) return false;
            else {
                return find(word, node.children[c - 'a'], index + 1);
            }
        }
        return false;
    }
}
