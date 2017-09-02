package array;

public class mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 6, 8, 9, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 4, 6, 10};
        merge(nums1, 5, nums2, 5);
        for(int i : nums1) {
            System.out.println(i);
        }
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while(index1 >= 0 && index2 >= 0) {
            if(nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }

        while(index1 >= 0) {
            nums1[index--] = nums1[index1--];
        }

        while(index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }
}
