package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        helper(result, list, 0, candidates, target);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int position, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int i = position; i < candidates.length; i++) {
            if (i != position && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target < candidates[i]) {
                break;
            }

            list.add(candidates[i]);
            helper(result, list, i + 1, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
