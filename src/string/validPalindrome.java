package string;

public class validPalindrome {
    public static void main(String[] args) {
        validPalindrome obj = new validPalindrome();
        String test = "A man, a plan, a canal: Panama";
        String test2 = "a";
        System.out.println(obj.isPalindrome(test));
    }
    private boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        int start = 0;
        int end =s.length() - 1;
        while(start < end) {
            while(start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            if(start == s.length()) {
                return true;
            }
            while(end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                start++;
                end--;
            }
        }
        return end <= start;
    }
    private boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
