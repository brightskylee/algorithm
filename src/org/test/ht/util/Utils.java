package org.test.ht.util;

import java.util.ArrayList;
import java.util.List;

import org.test.ht.TreeNode;

public class Utils {

    public static TreeNode arrayToTree(List<Integer> arr) {

        List<TreeNode> treeNodes = new ArrayList<>(arr.size());

        TreeNode root = new TreeNode(arr.get(0));
        treeNodes.add(root);

        for(int i=1; i<arr.size(); i++) {

            if (arr.get(i) != null) {
                TreeNode treeNode = new TreeNode(arr.get(i));
                treeNodes.add(treeNode);
                if (i % 2 == 0) {
                    int parent = i/2 - 1;
                    treeNodes.get(parent).right = treeNode;
                }
                else {
                    int parent = i/2;
                    treeNodes.get(parent).left = treeNode;
                }
            }
            else {
                treeNodes.add(null);
            }
        }

        return root;
    }
}
