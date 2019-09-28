package org.test.ht;

public class IsValidBST {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static class CompareValue {
        int val;
        boolean isNodeValue;

      public CompareValue(int val, boolean isNodeValue) {
          this.val = val;
          this.isNodeValue = isNodeValue;
      }
  }



    public static boolean isValidBST(TreeNode root) {
        return isValidBSTWithMinMax(root, new CompareValue(Integer.MIN_VALUE, false), new CompareValue(Integer.MAX_VALUE, false));
    }

    public static boolean isValidBSTWithMinMax(TreeNode root, CompareValue min, CompareValue max) {

        if (root == null) {
            return true;
        }

        if ((root.val <= min.val && min.isNodeValue) || (root.val >= max.val && max.isNodeValue)) {
            return false;
        }


        return isValidBSTWithMinMax(root.left, min, new CompareValue(root.val, true)) && isValidBSTWithMinMax(root.right, new CompareValue(root.val, true), max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);


        TreeNode right = new TreeNode(Integer.MAX_VALUE);
        right.left = new TreeNode(Integer.MIN_VALUE);

        root.right = right;

        System.out.println(isValidBST(root));
    }
}
