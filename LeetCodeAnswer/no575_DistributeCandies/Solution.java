package no575_DistributeCandies;

import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<Integer>();
        int max = candies.length / 2;
        int kinds = 0;
        for (int candy : candies) {
            if (set.contains(candy)) {
                continue;
            }
            set.add(candy);
            kinds++;
            if (kinds > max) return max;
        }
        return kinds;
    }
}