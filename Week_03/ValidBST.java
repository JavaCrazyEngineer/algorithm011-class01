/**
 * ClassName: ValidBST
 * Description:是否为二叉搜索树
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }


    private boolean help(TreeNode root, Integer low, Integer high) {
        if(root==null){
            return true;
        }
        return (null==low||root.val>low)&&(null==high||root.val<high)
                &&help(root.left,low,root.val)&&help(root.right,root.val,high);
    }


}
