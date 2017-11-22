package no652_FindDuplicateSubtrees;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<String, Integer>(), res);
        return res;
    }

    public String helper(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "";  
        String serial = cur.val + "," + helper(cur.left, map, res) + "," + helper(cur.right, map, res);
        if (!map.containsKey(serial)) {
        	map.put(serial, 1);
        } else {
        	map.put(serial, map.get(serial) + 1);
        }
        if (map.get(serial) == 2) res.add(cur);
        return serial;
    }
}