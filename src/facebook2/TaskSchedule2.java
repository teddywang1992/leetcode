package facebook2;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedule2 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(getStr(s, 5));
        System.out.println(count + s.length());
    }
    static int count = 0;
    public static String getStr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                int idx = map.get(c);
                while(sb.length() < idx + k) {
                    sb.append(" ");
                    count++;
                }
            }
            sb.append(c);
            map.put(c,sb.length());
        }
        return sb.toString();
    }
}
