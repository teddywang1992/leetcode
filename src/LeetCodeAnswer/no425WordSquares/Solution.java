package LeetCodeAnswer.no425WordSquares;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (words.length == 0 || words[0].length() == 0)
			return ret;
		Map<String, Set<String>> map = new HashMap<>();
		int squareLen = words[0].length();
		// create all prefix
		for (int i = 0; i < words.length; i++) {
			for (int j = -1; j < words[0].length(); j++) {
				if (!map.containsKey(words[i].substring(0, j + 1)))
					map.put(words[i].substring(0, j + 1), new HashSet<String>());
				map.get(words[i].substring(0, j + 1)).add(words[i]);
			}
		}
		helper(ret, new ArrayList<String>(), 0, squareLen, map);
		return ret;
	}

	public void helper(List<List<String>> ret, List<String> cur, int matched,
			int total, Map<String, Set<String>> map) {
		if (matched == total) {
			ret.add(new ArrayList<String>(cur));
			return;
		}
		// build search string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= matched - 1; i++)
			sb.append(cur.get(i).charAt(matched));
		// bachtracking
		Set<String> cand = map.get(sb.toString());
		if (cand == null)
			return;
		for (String str : cand) {
			cur.add(str);
			helper(ret, cur, matched + 1, total, map);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("abc".substring(0, 1));
	}
}

class Solution2 {
    
    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        List<String> words = new ArrayList<>();
        public TrieNode() {
            
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            root.words = Arrays.asList(words);
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.nodes[idx] == null)
                        cur.nodes[idx] = new TrieNode();
                    cur.nodes[idx].words.add(w);
                    cur = cur.nodes[idx];
                }
            }
        }
        
        public List<String> findByPrefix(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.nodes[idx] == null)
                    return new ArrayList<String>();

                cur = cur.nodes[idx];
            }
            return cur.words;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || words[0].length() == 0) return res;
        Trie trie = new Trie(words);
        int len = words[0].length();
        dfs(len, trie, res, list);

        return res;
    }
    
    private void dfs(int len, Trie tr, List<List<String>> ans,
            List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : ansBuilder)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            dfs(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
}