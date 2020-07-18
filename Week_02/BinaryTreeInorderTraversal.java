import java.util.*;

/**
 * ClassName: BinaryTreeInorderTraversal
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null != root) {
            List<Integer> inorders = new ArrayList<>(6);
            inorderTraversal(root, inorders);
            return inorders;
        }
        return Collections.emptyList();
    }

    /**
     * @param root
     * @param inorders
     */
    private void inorderTraversal(TreeNode root, List<Integer> inorders) {
        if (null == root) {
            return;
        }
        inorderTraversal(root.left, inorders);
        inorders.add(root.val);
        inorderTraversal(root.right, inorders);
    }




    public List<Integer> inorderTraversal1(TreeNode root) {
        if (null != root) {
            List<Integer> inorders = new ArrayList<>(6);
            inorderTraversal1(root, inorders);
            return inorders;
        }
        return Collections.emptyList();
    }


    private void inorderTraversal1(TreeNode root, List<Integer> inorders) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> deque=new ArrayDeque<>();
        while(root!=null||deque.size()>0){
            while(null!=root){
                deque.add(root);
                root=root.left;
            }
            root=deque.poll();
            inorders.add(root.val);
            root=root.right;
        }
    }

    public static void main(String[] args) {
        // [1,null,2,3]

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        right.left = left;
        root.right = right;
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal1(root));
    }
}
