package facebook2;

import java.util.HashSet;
import java.util.Set;

public class SubArrayEqualsK {

//    给一个数字array , 有正有负数。给一个数， 找array中连续的数字，其和是给定的数。leecode应该有类似的题目，但记不清了。是用hash table做的
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197490&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//
//    Subarray Equals K (consecutive sequcnce sum equals to k)
    // Use hashSet to store the sum, rang[i ~ j] = sum[j] - sum[i] = k
// Set.contains(sum - k), return true
    class SubarrayEqualsK {
        public boolean findSubarray(int[] input, int k) {
            Set<Integer> sums = new HashSet<>();
            int sum = 0;
            for (int number : input) {
                sum += number;
                if (sums.contains(sum - k)) {
                    return true;
                }
                sums.add(sum);
            }
            return false;
        }
    }
}
