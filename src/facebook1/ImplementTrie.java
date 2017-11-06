package facebook1;

class Trie {
    Trie[] children;
    boolean isWord;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertElement(word, 0);
    }

    public void insertElement(String word, int index) {
        if (index == word.length()) {
            this.isWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) children[pos] = new Trie();
        children[pos].insertElement(word, index + 1);
    }

    public Trie find(String word, int index) {
        if (index == word.length()) return this;
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) return null;
        return children[pos].find(word, index + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = find(word, 0);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = find(prefix, 0);
        return node != null;
    }
}
