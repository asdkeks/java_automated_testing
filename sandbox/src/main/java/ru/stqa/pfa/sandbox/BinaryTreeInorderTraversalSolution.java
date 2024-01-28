package ru.stqa.pfa.sandbox;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalSolution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;
        if (root.left != null) result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        if (root.right != null) result.addAll(inorderTraversal(root.right));
        return result;
    }
}
