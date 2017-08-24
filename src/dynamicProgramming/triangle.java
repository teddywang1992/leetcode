package dynamicProgramming;
/*
                                     [2],
                                    [3,4],
                                   [6,5,7],
                                  [4,1,8,3]
 */

import java.util.ArrayList;
import java.util.List;

public class triangle {
    public static void main(String[] args) {
        triangle obj = new triangle();
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> level0 = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        List<Integer> level2 = new ArrayList<>();
        List<Integer> level3 = new ArrayList<>();
        level0.add(2);
        level1.add(3);
        level1.add(4);
        level2.add(6);
        level2.add(5);
        level2.add(7);
        level3.add(4);
        level3.add(1);
        level3.add(8);
        level3.add(3);
        test.add(level0);
        test.add(level1);
        test.add(level2);
        test.add(level3);
        System.out.println(obj.minimumTotal(test));
    }
    private int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return -1;
        }
        if(triangle.get(0).size() == 0 || triangle.get(0) == null) {
            return -1;
        }

        //state
        int n = triangle.size();
        int[][] f = new int[n][n];

        //init
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1 ; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }

        //top down
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        //answer
        int min = f[n - 1][0];
        for(int i = 1; i < n; i++) {
            min = Math.min(min, f[n - 1][i]);
        }
        return min;
    }

}
