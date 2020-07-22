package week03_2;

import week02_2.TreeNode;

/**
 * 最小深度
 */
public class MinDepth {

    /**
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftDepth=minDepth(root.left);

        int rightDepth=minDepth(root.right);

        return (0==leftDepth||0==rightDepth)?leftDepth+rightDepth+1:Math.min(leftDepth,rightDepth)+1;
    }
}
