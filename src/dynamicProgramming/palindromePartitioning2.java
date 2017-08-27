package dynamicProgramming;

public class palindromePartitioning2 {
    public static void main(String[] args) {
        palindromePartitioning2 obj = new palindromePartitioning2();
        String test = "aab";
        obj.minCut(test);
    }
//    private boolean[][] getIsPalindrome(String s) {
//        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
//
//        for (int i = 0; i < s.length(); i++) {
//            isPalindrome[i][i] = true;
//        }
//        for (int i = 0; i < s.length() - 1; i++) {
//            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
//        }
//
//        for (int length = 2; length < s.length(); length++) {
//            for (int start = 0; start + length < s.length(); start++) {
//                isPalindrome[start][start + length]
//                        = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
//            }
//        }
//
//        return isPalindrome;
//    }
//
//    public int minCut(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        // preparation
//        boolean[][] isPalindrome = getIsPalindrome(s);
//
//        // initialize
//        int[] f = new int[s.length() + 1];
//        f[0] = 0;
//
//        // main
//        for (int i = 1; i <= s.length(); i++) {
//            f[i] = Integer.MAX_VALUE; // or f[i] = i
//            for (int j = 0; j < i; j++) {
//                if (isPalindrome[j][i - 1]) {
//                    System.out.println(s.substring(j, i));
//                    System.out.println("i before: " + i + " is: " + f[i]);
//                    System.out.println("j before: " + j + " is: " + f[j]);
//                    f[i] = Math.min(f[i], f[j] + 1);
//                    System.out.println("i after: " + i + " is: " + f[i]);
//                    System.out.println("j after: " + j + " is " + f[j]);
//                }
//            }
//        }
//
//        return f[s.length()] - 1;
//    }

    private int minCut(String s) {
        if(s == null) {
            return 0;
        }

        //state
        int n = s.length();
        int[] f = new int[n + 1];

        //init
        f[0] = 0;
        for(int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        //top down
        for(int i = 1; i <= n; i++) {
            //f[i] = Integer.MAX_VALUE; // or f[i] = i
            for(int j = 0; j < i; j++) {
                //System.out.println(s.substring(j, i));
                //System.out.println(isPalindrome(s.substring(j, i)));
                if(isPalindrome(s.substring(j, i))) {
                    System.out.println(s.substring(j, i));
                    System.out.println("i before: " + i + " is: " + f[i]);
                    System.out.println("j before: " + j + " is: " + f[j]);
                    f[i] = Math.min(f[i], f[j] + 1);
                    System.out.println("i after: " + i + " is: " + f[i]);
                    System.out.println("j after: " + j + " is " + f[j]);
                }
            }
        }

        //answer
        return f[s.length()] - 1;
    }
    private boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            while(start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            if(start == s.length()) {
                return true;
            }
            while(end >= 0 && !isValid(s.charAt(end)) ) {
                end--;
            }
            //if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.char(end))) {
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                start++;
                end--;
            }
        }
        return start >= end;
    }
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
