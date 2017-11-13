package FacebookInterview;

public class RemoveElement {
    public static void main(String[] args) {
        String s = "cbacdcbc";

        System.out.println(removeDuplicateLetters(s));
    }

    public static String remove(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + remove(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < s.charAt(pos)) pos = i; //找到a的位置把cb去掉
            if (--counter[s.charAt(i) - 'a'] == 0) break; //如果后面实在不能再删除了，我们就把重复的字母留下
        }

        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1)).replaceAll("" + s.charAt(pos), "");
    }
}
