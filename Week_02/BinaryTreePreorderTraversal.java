import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinaryTreePreorderTraversal
 * Description:二叉树前序遍历
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrders = new ArrayList<>(6);
        preorderTraversal(root, preOrders);
        return preOrders;
    }

    /**
     * @param root
     * @param preOrders
     */
    private void preorderTraversal(TreeNode root, List<Integer> preOrders) {
        if (null == root) {
            return;
        }
        preOrders.add(root.val);
        preorderTraversal(root.left, preOrders);
        preorderTraversal(root.right, preOrders);
    }
}
