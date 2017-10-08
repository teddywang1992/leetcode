package ebay;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1, 4);
        list.add(2);
        list.add(3);

        System.out.println(list.get(4));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            int size = list.size();
            for (int j = 1; j < size - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}
