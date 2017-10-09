package ebay;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> interSection = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) interSection.add(num);
        }

        int[] result = new int[interSection.size()];
        int i = 0;
        for (int num : interSection) {
            result[i] = num;
            i++;
        }

        return result;
    }
}
