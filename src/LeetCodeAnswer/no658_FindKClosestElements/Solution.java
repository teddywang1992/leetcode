package LeetCodeAnswer.no658_FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 1) {
            res.add(arr[0]);
            return res;
        }
        int start = 0, end = arr.length - k, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (Math.abs(arr[mid] - x) <= Math.abs(arr[mid + k] - x)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int index = 0;
        if (Math.abs(arr[start] - x) <= Math.abs(arr[start + k] - x)) {
            index = start;
        } else {
            index = end;
        }
        for (int i = index; i < index + k; i++) res.add(arr[i]);
        return res;
    }
}