package facebook2;

public class FindFirstLeft {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,1,1,1},{1,1,1,1,1},{0,0,0,0,1},{0,0,1,1,1}};
        System.out.println(findColumn(matrix));
    }

    public static int findColumn(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        boolean found = false;
        while(i < rows && j >= 0) {
            if(matrix[i][j] == 1) {
                j--;
                found = true;
            }
            else {
                i++;
            }
        }

        return found? j + 1: -1;
    }

    private static int getLeftCol(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        int result = Integer.MAX_VALUE;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length) {
            while (j >= 0) {
                if (j >= 0 && matrix[i][j] == 1) {
                    result = j;
                    j--;
//                    if (i == 0 && j )
                }
                else {
                    i++;
                    break;
                }
            }
        }
        return result;
    }




}
