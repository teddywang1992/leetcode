package array;

/*
其核心思想快慢指针在之前的题目Linked List Cycle II中就有应用，这里应用的更加巧妙一些，由于题目限定了区间[1,n]，
所以可以巧妙的利用坐标和数值之间相互转换，而由于重复数字的存在，那么一定会形成环

证明： 当fast若与slow相遇时，slow肯定没有走遍历完链表，而fast已经在环内循环了n圈(1<=n)。假设slow走了s步，
则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：

2s = s + nr
s= nr

设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
a + x = nr
a + x = (n – 1)r +r = (n-1)r + L - a
a = (n-1)r + (L – a – x)

(L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点，于是我们从链表头、
与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点
*/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
