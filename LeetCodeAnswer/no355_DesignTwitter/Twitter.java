package no355_DesignTwitter;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Twitter {

    /** Initialize your data structure here. */
    List<Tweet> tweets;
    HashMap<Integer, HashSet<Integer>> follow;
    public Twitter() {
        tweets = new ArrayList<Tweet>();
        follow = new HashMap<Integer, HashSet<Integer>>();
    }
    
    class Tweet {
        int userId;
        int tweetId;
        public Tweet (int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    
    private void init(int userId) {
        follow.putIfAbsent(userId, new HashSet<Integer>());
        if (follow.get(userId).isEmpty()) follow.get(userId).add(userId);
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        init(userId);
        Tweet tweet = new Tweet(userId, tweetId);
        tweets.add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<Integer>();
        if (!follow.containsKey(userId)) return news;
        for (int i = tweets.size() - 1; i >= 0; i--) {
            Tweet t = tweets.get(i);
            if (follow.get(userId).contains(t.userId)) {
                news.add(t.tweetId);
            }
            if (news.size()>=10) break;
        }
        return news;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new HashSet<Integer>());
        if (follow.get(followerId).isEmpty()) follow.get(followerId).add(followerId);
        follow.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId==followeeId) return;
        if (follow.containsKey(followerId)) follow.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
