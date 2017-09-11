package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        if (nums.length == 0) {
            result.add(list);
            return result;
        }

        Arrays.sort(nums);
        permuteHelper(result, list, nums);

        return result;
    }

    private static void permuteHelper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }

            list.add(num);
            permuteHelper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
