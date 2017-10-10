package ebay;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

    public static List<String> readBinaryWatch(int num) {
        String[] map = {"1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"};
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (num <= 0) return result;

        helper(result, list, map, num);
        return result;
    }

    private static void helper(List<String> result, List<String> list, String[] map, int num) {
        if (num == 0) result.addAll(list);

        for (int i = 0; i < map.length; i++) {
            if (list.contains(map[i])) continue;

            list.add(map[i]);
            helper(result, list, map, num - 1);
            list.remove(list.size() - 1);

        }
    }
}
