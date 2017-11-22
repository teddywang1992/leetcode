package no390_EliminationGame;

public class Solution {
    public int lastRemaining(int n) {
        return runLeft(n);
    }
    
    private int runLeft(int n){
        if (n == 1) return 1;
        else {
            return 2 * runRight(n / 2);
        }
    }
    
    private int runRight(int n){
        if (n == 1) return 1;
        else {
            if (n % 2==0){
                return 2 * runLeft(n / 2)-1;
            } else {
                return 2 * runLeft(n / 2);
            }
        }
    }
}
