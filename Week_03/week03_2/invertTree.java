package week03_2;
import week02_2.TreeNode;
/**
 * 翻转二叉树
 */
public class invertTree {

    /**
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=invertTree(right);
        root.right=invertTree(left);
        return root;
    }
}
