import java.util.LinkedList;
import java.util.Queue;
/**
 * 二叉树的最小高度
 */
public class BinaryTreeMinDepth {

    /**
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                //判断是否到达终点
                if (cur.left == null || cur.right == null) {
                    return depth;
                }
                //将cur的相邻节点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            //增加步数
            depth++;
        }
        return depth;
    }
}
