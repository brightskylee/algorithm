package org.test.ht;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BTInorderTraversal {

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
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode current = root;
        queue.add(current);
        while(!queue.isEmpty()) {
            current = queue.getLast();
            while((current = current.left) != null && !visited.contains(current)) {
                queue.add(current);
            }
            current = queue.pollLast();
            visited.add(current);
            result.add(current.val);

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }



}
