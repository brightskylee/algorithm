package org.test.ht;

import java.util.Arrays;
import java.util.List;

import org.test.ht.util.Utils;

public class RecoverBinarySearchTree {

    private TreeNode swappedANode = null, swappedBNode = null;

    public void recover(TreeNode root) {
        dfsCheckRightRelationship(root, null, false);
        if (swappedANode == null) {
            dfsCheckLeftRelationship(root, null, false);
        }
        int temp = swappedANode.val;
        swappedANode.val = swappedBNode.val;
        swappedBNode.val = temp;
        return;
    }

    public void dfsCheckRightRelationship(TreeNode node, TreeNode lastRight, boolean occurredRight) {

        if (node == null) {
            return;
        }

        if (lastRight != null && node.val < lastRight.val) {
            if (occurredRight) {
                swappedBNode = node;
            }
            else {
                swappedANode = lastRight;
                swappedBNode = node;
                occurredRight = true;
            }
        }

        dfsCheckRightRelationship(node.left, lastRight, occurredRight);
        dfsCheckRightRelationship(node.right, node, occurredRight);
    }

    public void dfsCheckLeftRelationship(TreeNode node, TreeNode lastLeft, boolean occurredLeft) {

        if (node == null) {
            return;
        }

        if (lastLeft != null && node.val > lastLeft.val) {
            if (occurredLeft) {
                swappedANode = node;
            }
            else {
                swappedANode = node;
                swappedBNode = lastLeft;
                occurredLeft = true;
            }
        }

        dfsCheckLeftRelationship(node.left, node, occurredLeft);
        dfsCheckLeftRelationship(node.right, lastLeft, occurredLeft);
    }

    public static void main(String[] args) {
        List<Integer> arrs = Arrays.asList(1, 3, 5, null, null, 4, 20, null, null, null, null, null, null, 15, 21, null, null,null,null,null,null,null,null,null,null,null,null,14,17,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,16,18,null,null,null,null);
        TreeNode root = Utils.arrayToTree(arrs);
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recover(root);
    }
}
