package dataStructure;

import java.util.*;

public class topKFrequentElements {
    private static class HashMapComparator implements Comparator<HashMap.Entry<Integer, Integer>> {
        public int compare(HashMap.Entry<Integer, Integer> entry1, HashMap.Entry<Integer, Integer> entry2) {
            return entry1.getValue() - entry2.getValue();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Queue<HashMap.Entry<Integer, Integer>> heap = new PriorityQueue<>(new HashMapComparator());

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else if (entry.getValue() > heap.peek().getValue()) {
                heap.poll();
                heap.offer(entry);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : heap) {
            result.add(entry.getKey());
        }

        return result;
    }
}
