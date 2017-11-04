package facebook1;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) return "";
        StringBuilder result = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                int count = 1;
                char say = result.charAt(j);
                while (j < result.length() - 1 && result.charAt(j + 1) == say) {
                    j++;
                    count++;
                }
                sb.append(count).append(say);
            }
            result = sb;
        }

        return result.toString();
    }
}
