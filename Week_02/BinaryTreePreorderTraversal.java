import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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


    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> preOrders = new ArrayList<>(6);
        preorderTraversal(root, preOrders);
        return preOrders;
    }

    /**
     * @param root
     * @param preOrders
     */
    private void preorderTraversal1(TreeNode root, List<Integer> preOrders) {
        if (null == root) {
            return;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()){
            TreeNode treeNode=deque.poll();
            preOrders.add(treeNode.val);
            if(null!=root.right){
                deque.add(root.right);
            }
            if(null!=root.left){
                deque.add(root.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal1(root));
    }
}
