package string;

public class ReverseWordsInaString3 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] strings = s.split(" ");
    }

    private static String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();

        for (; start < chars.length; start++) {
            if (chars[start] != ' ') {
                end = start;
                while (end + 1 < chars.length && chars[end + 1] != ' ') {
                    end++;
                }
                swap(chars, start, end);
                start = end;
            }
        }

        return new String(chars);
    }

    private static void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
