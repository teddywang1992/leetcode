package facebook2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    //16. 一个中国人面我的，态度很好，是messenger组的，写了2个题。第一个题其实很简单，check consecutive subarray duplicate numbers,
//    就是用hashset查重复就可以了，关键是窗口的移动。我写的很差，他让optimize到O（n）, 最后他给了个hint, 当时脑子蒙了，没有想到一个key point,
//    然后我说might work, 他冷嘲热讽了一句“might ? haha ”，我当时心里就哭了。。。. 1point 3acres 璁哄潧
//        第二题很顺利，就是remove invalid（（））【】什么的，leetcode上做过
//        大家都在问第一题，大概是这个意思：给一个array, 然后给一个k, 让你check 连续的k个integer是否含有dulplicate, 很简单的，
//    用窗口为K的hashset一直扫一遍就行了，很简单
//        http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=175190&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//
//        check duplicate numbers in window k
//        HashMap
    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    //        HashSet
    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int low = 0;
        int high = 0;
        while (high < nums.length) {
            if (window.size() >= k) {
                window.remove(nums[low]);
                low++;
            }
            if (window.contains(nums[high])) {
                return true;
            }
            else {
                window.add(nums[high]);
                high++;
            }

        }
        return false;
    }
}
