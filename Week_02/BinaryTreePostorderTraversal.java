import java.util.*;

public class BinaryTreePostorderTraversal {

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> resultList=new LinkedList<>();
        if(null==root){
            return resultList;
        }
        postorderTraversal(root,resultList);
        return resultList;
    }

    /**
     *
     * @param root
     * @param resultList
     */
    private void postorderTraversal(TreeNode root, LinkedList<Integer> resultList) {

        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode pollNode= deque.poll();
            resultList.addFirst(pollNode.val);
            if(null!=pollNode.left){
                deque.add(pollNode.left);
            }
            if(null!=pollNode.right){
                deque.add(pollNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(root));
    }
}
