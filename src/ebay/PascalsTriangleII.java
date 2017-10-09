package ebay;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            int size = result.size();
            result.add(0, 1);
            for (int j = 1; j < size; j++) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }
        return result;
    }
}
