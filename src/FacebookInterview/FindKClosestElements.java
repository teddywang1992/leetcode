package FacebookInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = (low + high) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        for (int i = low; i < k + low; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
