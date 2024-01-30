package ru.stqa.pfa.sandbox;

public class SymmetricTreeSolution {
    public static boolean isSymmetric(TreeNode root) {
        if (root.left != null & root.right != null) return helper(root.left, root.right);
        else return root.left == null & root.right == null;
    }

    private static boolean helper(TreeNode left, TreeNode right) {

        if ((left == null & right != null) || (left != null & right == null)) return false;
        if (left == null & right == null) return true;
        if (left.val == right.val) {
            return (helper(left.left, right.right) & helper(left.right, right.left));
        } else return false;
    }
}
