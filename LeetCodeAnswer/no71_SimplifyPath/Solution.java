package no71_SimplifyPath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        HashSet<String> skip = new HashSet<String>(Arrays.asList("", ".", ".."));
        String[] strs = path.split("\\/");
        Stack<String> stack = new Stack<String>();
        for (String str : strs) {
            if (!stack.isEmpty() && str.equals("..")) stack.pop();
            if (skip.contains(str)) continue;
            stack.push(str);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}