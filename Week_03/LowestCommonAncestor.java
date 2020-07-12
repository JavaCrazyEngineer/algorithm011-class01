/**
 * ClassName: LowestCommonAncestor
 * Description:最近公共祖先
 *
 * @author G20200343080265
 * @date 2020/07/12
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||root==p||root==q){
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
