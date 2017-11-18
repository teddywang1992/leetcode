package FacebookInterview;

public class ReverseWordsInString {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        int start = 0, end = 0;
        while (end < str.length) {
            while (end < str.length && str[end] != ' ') {
                end++;
            }
            reverse(str, start, end - 1);
            end++;
            start = end;
        }
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
