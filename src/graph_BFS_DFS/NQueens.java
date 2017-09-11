package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }


//    private static List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//
//        if (n <= 0) {
//            return result;
//        }
//
//        search(result, list, n);
//
//        return result;
//    }
//
//    private static void search(List<List<String>> result, List<Integer> list, int n) {
//        if (list.size() == n) {
//            result.add(draw(list));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!isValid(list, i)) {
//                continue;
//            }
//
//            System.out.println(list);
//            list.add(i);
//            search(result, list, i);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    private static boolean isValid(List<Integer> list, int column) {
//        int size = list.size();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == column) {
//                return false;
//            }
//
//            if (list.get(i) + i == size + column) {
//                return false;
//            }
//
//            if (list.get(i) - i == size - column) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static List<String> draw(List<Integer> cols) {
//        List<String> result = new ArrayList<>();
//        //System.out.println(cols);
//
//        for (int i = 0; i < cols.size(); i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < cols.size(); j++) {
//                sb.append(j == cols.get(i) ? 'Q' : '.');
//            }
//            result.add(sb.toString());
//        }
//        //System.out.println(result);
//        return result;
//    }

    private static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private static void search(ArrayList<ArrayList<String>> results,
                        ArrayList<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            System.out.println(cols);
            cols.add(i);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private static ArrayList<String> drawChessboard(ArrayList<Integer> cols) {
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private static boolean isValid(ArrayList<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
}
