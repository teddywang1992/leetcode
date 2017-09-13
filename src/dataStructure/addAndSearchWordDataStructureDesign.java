package dataStructure;

public class addAndSearchWordDataStructureDesign {

}

class WordDictionary {
    private class TireNode {
        public TireNode[] children;
        public boolean hasWord;

        public TireNode() {
            children = new TireNode[26];
            hasWord = false;
        }
    }

    TireNode node;
    /** Initialize your data structure here. */
    public WordDictionary() {
        node = new TireNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TireNode current = node;

        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (current.children[position] == null) {
                current.children[position] = new TireNode();
            }

            current = current.children[position];

        }

        current.hasWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, node);
    }

    private boolean find(String word, int index, TireNode current) {
        if (index == word.length()) {
            return current.hasWord;
        }
        //System.out.println(index);
        Character c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    if (find(word, index + 1, current.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }else if (current.children[c - 'a'] != null) {
            return find(word, index + 1, current.children[c - 'a']);
        } else {
            return false;
        }
    }
}
