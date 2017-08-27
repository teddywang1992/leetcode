package dynamicProgramming;

public class editDistance {
    public static void main(String[] args) {
        editDistance obj = new editDistance();
        String word1 = "mart";
        String word2 = "karma";
        System.out.println(obj.minDistance(word1, word2));
    }
    private int minDistance(String word1, String word2) {
        //state
        int n = word1.length();
        int m = word2.length();
        int [][] f = new int[n + 1][m + 1];

        //init
        for(int i = 0; i < n + 1; i++) {
            f[i][0] = i;
        }
        for(int i = 0; i < m + 1; i++) {
            f[0][i] = i;
        }

        //top down
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = Math.min(f[i-1][j] + 1, Math.min(f[i][j-1] + 1, f[i-1][j-1]));
                } else if(word1.charAt(i-1) != word2.charAt(j-1)) {
                    f[i][j] = Math.min(f[i-1][j] + 1, Math.min(f[i][j-1] + 1, f[i-1][j-1] + 1));
                }
            }
        }

        //answer
        return f[n][m];
    }
}
