package FacebookInterview;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (nestedList == null) return result;
        for (NestedInteger node : nestedList) {
            helper(node, result);
        }
        return result;
    }

    private void helper(NestedInteger node, List<Integer> result) {
        if (node.isInteger()) {
            result.add(node.getInteger());
            return;
        }
        else {
            for (NestedInteger child : node.getList()) {
                helper(child, result);
            }
        }
    }

}
