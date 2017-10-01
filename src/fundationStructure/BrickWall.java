package fundationStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (List<Integer> list : wall) {
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }

        return wall.size() - count;
    }
}
