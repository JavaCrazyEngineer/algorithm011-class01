/**
 * ClassName: MaxDepth
 * Description:最小深度
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class MinDepth {


    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);

        return (leftDepth==0||rightDepth==0)?leftDepth+rightDepth+1:Math.min(leftDepth,rightDepth)+1;
    }
}
