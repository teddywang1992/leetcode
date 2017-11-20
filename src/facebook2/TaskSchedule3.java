package facebook2;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedule3 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(getStr(s, 5));
    }
    private static int getStr(String s, int k) {
        int len = 0;
        if (s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index + k > len) {
                    len = index + k;
                }
            }
            map.put(c, ++len);
        }
        return len;
    }

    private static String getStr2(String s, int k) {
        if (s == null) return "";
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int index = map.get(c);
                while (index + k > sb.length()) {
                    sb.append(" ");
                }
            }
            sb.append(c);
            map.put(c, sb.length());
        }
        return sb.toString();
    }
}
