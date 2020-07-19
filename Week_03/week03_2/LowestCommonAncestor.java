package week03_2;

import week02_2.TreeNode;

/**
 * 公共祖先
 */
public class LowestCommonAncestor {

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null||p==root||q==root){
          return root;
      }

      TreeNode left=lowestCommonAncestor(root.left,p,q);
      TreeNode right=lowestCommonAncestor(root.right,p,q);

      if(null!=left&&null!=right){
          return root;
      }else{
          return null!=left?left:right;
      }
    }
}
