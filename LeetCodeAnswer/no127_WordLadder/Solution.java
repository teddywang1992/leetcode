package no127_WordLadder;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		// BFS
		// if (beginWord.equals(endWord)) return 1;
		// Set<String> dict = new HashSet<>(wordList);
		// Queue<String> queue = new LinkedList<>();
		// Set<String> set = new HashSet<>();
		// queue.offer(beginWord);
		// set.add(beginWord);
		// int length = 1;
		// while (!queue.isEmpty()) {
		// length++;
		// int size = queue.size();
		// for (int i = 0; i < size; i++) {
		// String word = queue.poll();
		// for (String str : getNextWords(word, dict)) {
		// if (set.contains(str)) continue;
		// if (str.equals(endWord)) return length;
		// set.add(str);
		// queue.offer(str);
		// }
		// }
		// }
		// return 0;

		// double end BFS
		if (beginWord.equals(endWord))
			return 1;
		Set<String> left = new HashSet<>(), right = new HashSet<>(), vis = new HashSet<>(), dict = new HashSet<>(
				wordList);
		left.add(beginWord);
		if (dict.contains(endWord)) right.add(endWord);
		for (int len = 2; !left.isEmpty(); len++) {
			Set<String> tmp = new HashSet<>();
			for (String w : left) {
				for (int j = 0; j < w.length(); j++) {
					char[] chars = w.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == chars[j]) continue;
						chars[j] = c;
						String string = new String(chars);
						if (right.contains(string)) return len;
						if (dict.contains(string) && !vis.contains(string)) {
							vis.add(string);
							tmp.add(string);
						}
					}
				}
			}
			left = tmp.size() < right.size() ? tmp : right;
			right = left == tmp ? right : tmp;
		}
		return 0;
	}

	private List<String> getNextWords(String word, Set<String> dict) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (word.charAt(i) == c)
					continue;
				String str = replace(word, i, c);
				if (dict.contains(str))
					res.add(str);
			}
		}
		return res;
	}

	private String replace(String word, int i, char c) {
		char[] chars = word.toCharArray();
		chars[i] = c;
		return new String(chars);
	}
}