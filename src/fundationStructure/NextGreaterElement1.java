package fundationStructure;

/*
下面这种方法使用了哈希表和栈，但是这里的哈希表和上面的不一样，这里是建立每个数字和其右边第一个较大数之间的映射，
没有的话就是-1。我们遍历原数组中的所有数字，如果此时栈不为空，且栈顶元素小于当前数字，说明当前数字就是栈顶元素的右边第一个较大数，
那么建立二者的映射，并且去除当前栈顶元素，最后将当前遍历到的数字压入栈。当所有数字都建立了映射，
那么最后我们可以直接通过哈希表快速的找到子集合中数字的右边较大值
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        System.out.println(nextGreaterElement(nums1, nums2));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        for (int i : nums2) {
            map.put(i, -1);
        }

        for (int i = 0; i < nums2.length - 1; i++) {
            stack.push(nums2[i]);
            while (!stack.isEmpty() && nums2[i + 1] > stack.peek()) {
                map.put(stack.pop(), nums2[i + 1]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
