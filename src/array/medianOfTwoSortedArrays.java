package array;

public class medianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] numA = {1,2,3,6,9,10};
        int[] numB = {2,4,5,6,7};
        System.out.println(findMedianSortedArrays(numA, numB));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, length / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, length / 2) + findKth(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;
        }
    }
    private static int findKth(int[] nums1, int startNums1, int[] nums2, int startNums2, int k) {
        if(startNums1 >= nums1.length) {
            return nums2[startNums2 + k - 1];
        }
        if(startNums2 >= nums2.length) {
            return nums1[startNums1 + k - 1];
        }

        if(k == 1) {
            return Math.min(nums1[startNums1], nums2[startNums2]);
        }

        int nums1Value = startNums1 + k / 2 - 1 < nums1.length ? nums1[startNums1 + k / 2 - 1] : Integer.MAX_VALUE;
        int nums2Value = startNums2 + k / 2 - 1 < nums2.length ? nums2[startNums2 + k / 2 - 1] : Integer.MAX_VALUE;

        if(nums2Value > nums1Value) {
            return findKth(nums1, startNums1 + k / 2, nums2, startNums2, k - k / 2);
        } else {
            return findKth(nums1, startNums1, nums2, startNums2 + k / 2, k - k / 2);
        }
    }
}
