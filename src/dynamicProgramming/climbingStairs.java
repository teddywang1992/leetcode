package dynamicProgramming;

public class climbingStairs {
    public static void main(String[] args) {
        climbingStairs obj = new climbingStairs();
        System.out.println(obj.climbStairs(119));
    }
    private int climbStairs(int n) {
        //state
        int[] f = new int[n + 1];
        if(n == 1 || n == 0) {
            return 1;
        }
        if(n > 1) {
            f[0] = 1;
            f[1] = 1;
            //top down
            for(int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
        }

        //answer
        return f[n];
    }
}
