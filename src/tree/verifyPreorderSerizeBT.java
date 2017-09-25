package tree;

import java.util.Stack;

/*
there are two output which means it is not tree. The one is stack is empty. The other one is the stack size is not 1 and the peek
value is not #

this is bacause when we meet two #s  we just see the whole child node is like a new #.
*/

public class verifyPreorderSerizeBT {
    // when exhasted a tree, we push "#" to denote that this tree is valid
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String string : strings) {
            while (string.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(string);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
