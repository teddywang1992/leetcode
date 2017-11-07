package facebook1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (List<Integer> level : wall) {
            int length = 0;
            for (int i = 0; i < level.size() - 1; i++) {// 不能加上最后一个砖头，要不就变成0了
                length += level.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }

        return wall.size() - count;
    }
}
