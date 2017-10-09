package ebay;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] chars = num.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start <= end) {
            if ((chars[start] == chars[end] && chars[start] == '1')
                    || (chars[start] == chars[end] && chars[start] == '8' )
                    || (chars[start] == chars[end] && chars[start] == '0')) {
                start++;
                end--;
            } else if ((chars[start] == '6' && chars[end] == '9') || (chars[start] == '9' && chars[end] == '6')) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
