package microsoft;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int length = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[length--] = nums2[n--];
            } else {
                nums1[length--] = nums1[m--];
            }
        }

        while (n >= 0) {
            nums1[length--] = nums2[n--];
        }
    }
}
