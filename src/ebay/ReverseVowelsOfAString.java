package ebay;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            while (chars[start] != 'a'
                    && chars[start] != 'e'
                    && chars[start] != 'i'
                    && chars[start] != 'o'
                    && chars[start] != 'u'
                    && chars[start] != 'A'
                    && chars[start] != 'E'
                    && chars[start] != 'I'
                    && chars[start] != 'O'
                    && chars[start] != 'U') {
                start++;
                if (start > chars.length - 1) return s;
            }

            while (chars[end] != 'a'
                    && chars[end] != 'e'
                    && chars[end] != 'i'
                    && chars[end] != 'o'
                    && chars[end] != 'u'
                    && chars[end] != 'A'
                    && chars[end] != 'E'
                    && chars[end] != 'I'
                    && chars[end] != 'O'
                    && chars[end] != 'U') {
                end--;
                if (end < 0) return s;
            }

            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

            }
            start++;
            end--;
        }

        return new String(chars);
    }
}
