package microsoft;

public class ImplementTrie {
//    Trie[] children;
//    boolean isWord;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        children = new ImplementTriePrefixTree.Trie[26];
//        isWord = false;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || word.length() == 0) return;
//        add(word, 0);
//    }
//
//    public void add(String word, int index) {
//        if (index == word.length()) {
//            isWord = true;
//            return;
//        }
//        int cur = word.charAt(index) - 'a';
//        if (children[cur] == null) {
//            children[cur] = new Trie();
//        }
//        children[cur].add(word, index + 1);
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        Trie cur = find(word, 0);
//        return cur != null && cur.isWord;
//    }
//
//    public Trie find(String word, int index) {
//        if (index == word.length()) return this;
//        int cur = word.charAt(index) - 'a';
//        if (children[cur] == null) return null;
//        return children[cur].find(word, index + 1);
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        Trie cur = find(prefix, 0);
//        return cur != null;
//    }
}
