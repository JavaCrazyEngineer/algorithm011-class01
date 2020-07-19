package week03_2;

import week02_2.TreeNode;

/**
 * 最大深度
 */
public class MaxDepth {

    /**
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
