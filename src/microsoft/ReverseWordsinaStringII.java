package microsoft;

public class ReverseWordsinaStringII {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);

        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, start, str.length - 1);
    }

    private void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0) return;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
