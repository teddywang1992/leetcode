package string;

public class ReverseWordsInaString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWordsSplit(s));
    }

    private static String reverseWordsWithoutSplit(String s) {
        return null;
    }

    private static String reverseWordsSplit(String s) {
        String[] strings = s.split(" +");
        int start = 0;
        int end = strings.length - 1;
        // StringBuilder sb = new StringBuilder();

        while (start < end) {
            String temp = strings[start];
            strings[start] = strings[end];
            strings[end] = temp;
            start++;
            end--;
        }

        return String.join(" ", strings).trim();
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();

        reverse(chars, 0, chars.length - 1);

        reverseWord(chars);

        return removeSpace(chars);
    }

    private String removeSpace(char[] chars) {
        int start = 0;
        int end = 0;

        while (end < chars.length) {
            while (end < chars.length && chars[end] == ' ') {
                end++;
            }

            while (end < chars.length && chars[end] != ' ') {
                chars[start] = chars[end];
                end++;
                start++;
            }

            while (end < chars.length && chars[end] == ' ') {
                end++;
            }

            if (end < chars.length) {
                chars[start] = ' ';
                start++;
            }
        }

        return new String(chars).substring(0, start);
    }

    private void reverseWord(char[] chars) {
        int length = chars.length;
        int start = 0;
        int end = 0;

        while (start < length) {
            while (start < end || start < length && chars[start] == ' ') start++;
            while (end < start || end < length && chars[end] != ' ') end++;
            reverse(chars, start, end - 1);
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
