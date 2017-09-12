package dataStructure;

public class implementTrie {
    public static void main(String[] args) {
        TrieUseArray node = new TrieUseArray();
        node.insert("ab");
        System.out.println(node.search("a"));
        System.out.println(node.startsWith("a"));
    }
}

class TrieUseArray {
    private TrieUseArray[] children;
    public boolean hasWord;

    /** Initialize your data structure here. */
    public TrieUseArray() {
        children = new TrieUseArray[26];
        hasWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertElement(word, 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieUseArray node = find(word, 0);
        return node != null && node.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix, 0) != null;
    }

    private void insertElement(String word, int index) {
        if (index == word.length()) {
            hasWord = true;
            return;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieUseArray();
        }

        children[pos].insertElement(word, index + 1);
    }

    private TrieUseArray find(String word, int index) {
        if (index == word.length()) {
            return this;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }

        return children[pos].find(word, index + 1);
    }
}


