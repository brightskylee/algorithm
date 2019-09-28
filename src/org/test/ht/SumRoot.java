package org.test.ht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumRoot {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        for (String s : splitToNumbers(root)) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    private static List<String> splitToNumbers(TreeNode root) {
        List<String> numbers = new ArrayList<>();
        if (root.left != null) {
            List<String> leftNumbers = splitToNumbers(root.left);
            for (String n : leftNumbers) {
                numbers.add(root.val + n);
            }
        }

        if (root.right != null) {
            List<String> rightNumbers = splitToNumbers(root.right);
            for (String n : rightNumbers) {
                numbers.add(root.val + n);
            }
        }

        if (numbers.isEmpty()) {
            return Collections.singletonList(String.valueOf(root.val));
        }



        return numbers;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;

        treeNode5.left = treeNode3;
//        treeNode5.right = treeNode4;

        SumRoot sumRoot = new SumRoot();
        System.out.println(sumRoot.sumNumbers(treeNode5));

    }
}
