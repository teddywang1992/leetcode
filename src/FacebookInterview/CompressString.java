package FacebookInterview;

public class CompressString {
    public static void main(String[] args) {
        String s = "aaabbbbbaaddd";
        System.out.println(compress(s));
    }

    private static String compress(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}
