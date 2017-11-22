package LeetCodeAnswer.no501_FindModeInBinarySearchTree;

import helper.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Map<Integer, Integer> map; 
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0]; 
        this.map = new HashMap<Integer, Integer>(); 
        
        inorder(root); 
        
        List<Integer> list = new ArrayList<Integer>();
        for(int key: map.keySet()){
            if(map.get(key) == max) list.add(key);
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; i++) res[i] = list.get(i);
        return res; 
    }
    
    private void inorder(TreeNode node){
        if(node.left!=null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max = Math.max(max, map.get(node.val));
        if(node.right!=null) inorder(node.right); 
    }
}