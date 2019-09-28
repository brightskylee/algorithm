package org.test.ht;

public class MaxPathBinaryTree {

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(max, root);
        return max[0];
    }
    int maxPathSum(int[] max, TreeNode root){
        if(root==null) return 0;
        int l = maxPathSum(max, root.left);
        int r = maxPathSum(max, root.right);
        max[0] = Math.max(max[0], Math.max(0, Math.max(l+root.val, root.val+r)));
        return Math.max(0, Math.max(l+root.val, root.val+r));
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
//        TreeNode node5 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
//
//        node1.left = node5;
//        node1.right = node6;

        MaxPathBinaryTree maxPathBinaryTree = new MaxPathBinaryTree();
        System.out.println(maxPathBinaryTree.maxPathSum(root));
    }
}
