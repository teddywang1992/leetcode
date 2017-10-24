package microsoft;

public class AddandSearchWordDatastructuredesign {
    class Trie {
        public Trie[] children;
        public boolean hasWord;
        public Trie() {
            children = new Trie[26];
            hasWord = false;
        }
    }

    /** Initialize your data structure here. */
    Trie node;
    public AddandSearchWordDatastructuredesign() {
        node = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = node;
        if (word == null || word.length() == 0) return;

        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) cur.children[pos] = new Trie();
            cur = cur.children[pos];
            if (i == word.length() - 1) cur.hasWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie cur = node;
        return find(word, 0, cur);
    }

    public boolean find(String word, int index, Trie cur) {
        if (index == word.length()) return cur.hasWord;

        int pos = word.charAt(index) - 'a';
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (find(word, index + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else if (cur.children[pos] != null) {
            return find(word, index + 1, cur.children[pos]);
        } else {
            return false;
        }
    }
}
