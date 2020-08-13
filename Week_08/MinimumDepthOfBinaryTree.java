import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 */
public class MinimumDepthOfBinaryTree {

    /**
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }

    /**
     *
     * @param root
     * @return
     */
    public int minDepthI(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=1;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left==null||node.right==null){
                    return depth;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
