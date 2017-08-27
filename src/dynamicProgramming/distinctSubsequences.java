package dynamicProgramming;

public class distinctSubsequences {
    public static void main(String[] args) {
        distinctSubsequences obj = new distinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(obj.numDistinct(s,t));
    }
    private int numDistinct(String s, String t) {
        //state
        int n = s.length();
        int m = t.length();
        int [][] f = new int[n+1][m+1];

        //init
        for(int i = 0; i < n + 1; i++) {
            f[i][0] = 1;
        }
        for(int i = 1; i < m + 1; i++) {
            f[0][i] = 0;
        }

        //function
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(s.charAt(i - 1) == t.charAt(j  - 1)) {
                    f[i][j] = f[i-1][j] + f[i-1][j-1];
                } else if(s.charAt(i - 1) != t.charAt(j - 1)) {
                    f[i][j] = f[i-1][j];
                }
            }
        }

        //answer
        return f[n][m];
    }
}
