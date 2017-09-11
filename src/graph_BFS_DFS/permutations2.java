package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    private static List<List<Integer>> permuteUnique(int[] nums) {
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
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        permuteUniqueHelper(result, list, visited, nums);

        return result;
    }

    private static void permuteUniqueHelper(List<List<Integer>> result, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && visited[i])) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            permuteUniqueHelper(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
