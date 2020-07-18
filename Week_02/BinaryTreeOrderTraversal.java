import java.util.*;

public class BinaryTreeOrderTraversal {

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        TreeNode p=root;
        while(!deque.isEmpty()||null!=p){
            if(null!=p){
                deque.addFirst(p);
                result.add(p.val);
                p=p.left;
            }else{
                TreeNode node=deque.pollFirst();
                p=node.right;
            }
        }
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode p = root;

        while (!deque.isEmpty() || null != p) {
            if (null != p) {
                deque.addFirst(p);//add to first
                p = p.left;
            } else {
                TreeNode node = deque.pollFirst();//poll first
                result.add(node.val);
                p = node.right;
            }
        }
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result=new LinkedList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();

        TreeNode p=root;
        while(!deque.isEmpty()||null!=p){
            if(null!=p){
                deque.addFirst(p);
                result.addFirst(p.val);
                p=p.left;
            }else{
                TreeNode node=deque.pollFirst();
                p=node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(5);

        //System.out.print(new BinaryTreeOrderTraversal().preorderTraversal(root));
        //System.out.println(new BinaryTreeOrderTraversal().inorderTraversal(root));
        System.out.println(new BinaryTreeOrderTraversal().postorderTraversal(root));
    }
}
