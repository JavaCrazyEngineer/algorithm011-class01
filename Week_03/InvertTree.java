/**
 * ClassName: InvertTree
 * Description:翻转二叉树
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left= root.left;
        TreeNode right= root.right;
        root.left=invertTree(right);
        root.right=invertTree(left);
        return root;
    }
}
