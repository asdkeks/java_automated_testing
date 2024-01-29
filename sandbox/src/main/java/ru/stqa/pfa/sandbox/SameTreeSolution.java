package ru.stqa.pfa.sandbox;

import java.util.ArrayList;
import java.util.List;

public class SameTreeSolution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return (helper(p).equals(helper(q)));
    }

    private static List<Integer> helper(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            result.add(-1);
            return result;
        }
        result.add(root.val);
        result.addAll(helper(root.left));
        result.addAll(helper(root.right));
        return result;
    }
}
