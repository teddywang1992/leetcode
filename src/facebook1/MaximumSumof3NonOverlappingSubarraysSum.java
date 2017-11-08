package facebook1;

public class MaximumSumof3NonOverlappingSubarraysSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = new int[]{2,1,1,-1,3,6,-2,-4,1,2,-1,2,1,-1,2};
        int[] arr1 = new int[]{1,2,2,-1,1,2,1,3,5};
        int res = findMax(arr, 3);
        System.out.println(res);
    }

    private static int findMax(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int leftSum = 0;
        int rightSum = 0;
        int midSum = 0;

        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            if (i >= k) leftSum -= nums[i - k];
            if (i >= k - 1) left[i] = Math.max(leftSum, i >= 1 ? left[i - 1] : 0);
        }

        for (int i = len - 1; i >= 0; i--) {
            rightSum += nums[i];
            if (i < len - k) rightSum -= nums[i + k];
            if (i <= len - k) right[i] = Math.max(rightSum, i < len - 1 ? right[i + 1] : 0);
        }

        for (int i = k; i < len - k; i++) {
            midSum += nums[i];
            if (i >= k + k) midSum -= nums[i - k];
            if (i >= k + k - 1) res = Math.max(res, midSum + left[i - k] + right[i + 1]);
        }

        return res;
    }

//    public static int find(int[] arr, int k) {
//        int res = Integer.MIN_VALUE;
//        int len = arr.length;
//        int[] left = new int[len];
//
//        int lsum = 0;
//        for (int i=0; i<len; i++) {
//            lsum += arr[i];
//            if (i >= k) lsum -= arr[i-k];
//            if (i >= k-1) left[i] = Math.max(lsum, i>=1? left[i-1] : 0);//find the window end at i with max sum
//        }
//
//        int[] right = new int[len];
//        int rsum = 0;
//        for (int j=len-1; j>=0; j--) {
//            rsum += arr[j];
//            if (j < len-k) rsum -= arr[j+k];
//            if (j <= len-k) right[j] = Math.max(rsum, j<len-1? right[j+1] : 0);
//        }
//
//        int midSum = 0;
//        for (int t=k; t<=len-k-1; t++) {
//            midSum += arr[t];
//            if (t >= k + k) midSum -= arr[t-k];
//            if (t >= k + k - 1) { // for each size k window in the middle with sum as midSum
//                //find midSum + left[t-k] + right[t+1] that gives the max
//                res = Math.max(res, midSum + left[t-k] + right[t+1]);
//            }
//        }
//        return res;
//    }



}

