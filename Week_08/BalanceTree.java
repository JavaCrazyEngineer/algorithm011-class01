/**
 * 平衡二叉树
 */
public class BalanceTree {

    public boolean isBalanced(TreeNode root){
        return balanced(root)!=-1;
    }

    /**
     *从下往上遍历
     * @param root
     * @return
     */
    private int balanced(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight,rightHeight;

        if((leftHeight=balanced(root.left))==-1
        ||(rightHeight=balanced(root.right))==-1
                ||Math.abs(leftHeight-rightHeight)>1){//高度差大于1为非平衡二叉树，为-1也是非平衡二叉树
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;//左右最大高度+1
    }
}
