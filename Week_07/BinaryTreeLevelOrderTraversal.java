import java.util.*;
/**
 * ClassName: BinaryTreeLevelOrderTraversal
 * Description:二叉树的层序遍历
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/08/09
 */
public class BinaryTreeLevelOrderTraversal {


    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> bfsResult = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                levelResult.add(node.val);
            }
            bfsResult.add(levelResult);
        }
        return bfsResult;
    }


    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> dfsResult = new ArrayList<>();
        levelHelper(dfsResult, root, 0);
        return dfsResult;
    }

    /**
     * @param dfsResult
     * @param root
     * @param height
     */
    private void levelHelper(List<List<Integer>> dfsResult, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height > dfsResult.size()) {
            dfsResult.add(new LinkedList<Integer>());
        }
        dfsResult.get(height).add(root.val);
        levelHelper(dfsResult, root.left, height + 1);
        levelHelper(dfsResult, root.right, height + 1);
    }
}
