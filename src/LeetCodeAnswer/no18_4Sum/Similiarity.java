package LeetCodeAnswer.no18_4Sum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Tweet implements Comparable<Tweet> {
	Integer impactScore;
	String tweetId;
	String createdAt;
	String censoredText;
	public Tweet (int impactScore, String tweetId, String createdAt, String censoredText) {
		this.impactScore = impactScore;
		this.tweetId = tweetId;
		this.createdAt = createdAt;
		this.censoredText = censoredText;
	}
	public int compareTo(Tweet o) {
		return impactScore.compareTo(o.impactScore) == 0 ? this.tweetId.compareTo(o.tweetId) : this.impactScore.compareTo(o.impactScore);
	}
}
public class Similiarity {
	// similarity score of two users
	// All the shared words in lower case ordered alphabetically
	// Top n (ranking defined below) tweets of the first user that have any of the shared words (if there are fewer than n tweets satisfying the requirement, just return them all; if no tweets satisfy the requirement, just leave this part blank)
	// Top n (ranking defined below) tweets of the second user that have any of the shared words (if there are fewer than n tweets satisfying the requirement, just return them all; if no tweets satisfy the requirement, just leave this part blank)
	
	// Tweet: impact score, tweet id, createdAt, censored text
	// rank: impact score, id
	public void query_2(String[] user1, String[] user2, int n) {
		int score = 0;
		if (user1.length == 0 || user2.length == 0) score = 0;
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		HashSet<String> shareSet = new HashSet<String>();
		for (int i = 0; i < user1.length; i++) {
			String[] tweet = user1[i].split("[^a-zA-Z0-9]+");
			for (String s : tweet) {
				if (!map1.containsKey(s)) {
					map1.put(s, 1);
				} else {
					map1.put(s, map1.get(s) + 1);
				}
			}
		}
		for (int i = 0; i < user2.length; i++) {
			String[] tweet = user2[i].split("[^a-zA-Z0-9]+");
			for (String s : tweet) {
				if (!map1.containsKey(s)) {
					continue;
				} else {
					if (!!map2.containsKey(s)) {
						map2.put(s, 1);
						shareSet.add(s);
					} else {
						map2.put(s, map2.get(s) + 1);
					}
				}
			}
		}
		String[] shareStrings = shareSet.toArray(new String[shareSet.size()]);
		Arrays.sort(shareStrings);
		for (String word : shareStrings) {
			score += map1.get(word) * map2.get(word);
		}
		StringBuilder shareWords = new StringBuilder();
		for (int i = 0; i < shareStrings.length - 1; i++) {
			shareWords.append(shareStrings[i] + " ");
		}
		shareWords.append(shareStrings[shareStrings.length - 1]);
		String shareOutput = shareWords.toString();
		
	}
	public static void main(String[] args) {
		Similiarity s = new Similiarity();
		BigInteger user1 = new BigInteger("100");
		BigInteger user2 = new BigInteger("200");
		int n = 10;
//		s.query_2(user1, user2, n);
	}
}
