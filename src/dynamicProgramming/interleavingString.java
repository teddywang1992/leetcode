package dynamicProgramming;

public class interleavingString {
    public static void main(String[] args) {
        interleavingString obj = new interleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(obj.isInterleave(s1, s2, s3));
    }
    private boolean isInterleave(String s1, String s2, String s3) {
        //state
        int n = s1.length();
        int m = s2.length();
        boolean[][] f = new boolean[n+1][m+1];

        //function
        if(s3.length() == n + m) {
            //init
            f[0][0] = true;
            for(int i = 1; i < n + 1; i++) {
                f[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && f[i - 1][0];
            }
            for(int i = 1; i < m + 1; i++) {
                f[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && f[0][i - 1];
            }

            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < m + 1; j++) {
                    f[i][j] = (f[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (f[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        } else {
            return false;
        }

        //answer
        return f[n][m];
    }
}
