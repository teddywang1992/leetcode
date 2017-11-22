package no119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rst = new ArrayList<Integer>();
        rowIndex += 1;
        rst.add(1);
        for (int i = 1; i < rowIndex; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
            for (int j = 0; j < i + 1; j++) {
                tmp.add(-1);
            }
            tmp.set(0, rst.get(0));
            tmp.set(i, rst.get(i - 1));
            for (int j = 1; j < i; j++) {
                tmp.set(j, rst.get(j - 1) + rst.get(j));
            }
            rst = tmp;
        }
        return rst;
        
    }
}