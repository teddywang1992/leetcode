package microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int rowLeft = 0;
        int rowRight = matrix.length - 1;

        while (colLeft <= colRight && rowLeft <= rowRight) {
            for (int j = colLeft; j <= colRight; j ++) {
                list.add(matrix[rowLeft][j]);
            }
            rowLeft++;

            for (int j = rowLeft; j <= rowRight; j ++) {
                list.add(matrix[j][colRight]);
            }
            colRight--;

            if (rowLeft <= rowRight) {
                for (int j = colRight; j >= colLeft; j --) {
                    list.add(matrix[rowRight][j]);
                }
            }
            rowRight--;

            if (colLeft <= colRight) {
                for (int j = rowRight; j >= rowLeft; j --) {
                    list.add(matrix[j][colLeft]);
                }
            }
            colLeft++;
        }

        return list;
    }
}
