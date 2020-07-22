package week03_2;

import week02_2.TreeNode;

/**
 * 是否为二叉搜索树
 */
public class ValidBst {

    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return help(root,null,null);
    }

    /**
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    private boolean help(TreeNode root, Integer low, Integer high) {
      if(root==null){
          return true;
      }
      return (null==low||root.val>low)&&(null==high||root.val<high)
              &&help(root.left,low,root.val)&&help(root.right,root.val,high);
    }
}
