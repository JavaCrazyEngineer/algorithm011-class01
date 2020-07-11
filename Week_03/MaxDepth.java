/**
 * ClassName: MaxDepth
 * Description:最大深度
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
