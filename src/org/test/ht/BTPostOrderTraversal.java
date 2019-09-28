package org.test.ht;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BTPostOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(9);

        inorderTraversal(root);

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode current = root;
        queue.add(current);
        while(!queue.isEmpty()) {
            current = queue.pop();
            while((current = current.left) != null && !visited.contains(current)) {
                queue.add(current);
            }
            current = queue.pop();
            if ((current = current.right) != null && !visited.contains(current)) {
                queue.add(current);
            }
            else{
                current = queue.pop();
                visited.add(current);
                result.add(current.val);
            }
        }

        return result;
    }



}
