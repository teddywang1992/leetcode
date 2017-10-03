package ebay;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}
