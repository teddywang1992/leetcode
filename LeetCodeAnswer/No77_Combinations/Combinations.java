package No77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < k) return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, list, n, k, 1);
        return result;
    }

	private void dfs(List<List<Integer>> result, ArrayList<Integer> list,
			int n, int k, int pos) {
		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = pos; i <= n; i++) {
			list.add(i);
			dfs(result, list, n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		System.out.println(combinations.combine(4, 2));
	}

}
