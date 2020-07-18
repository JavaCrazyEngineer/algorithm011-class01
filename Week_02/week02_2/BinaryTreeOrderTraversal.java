package week02_2;
import java.util.*;

/**
 * 二叉树的遍历
 */
public class BinaryTreeOrderTraversal {
    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root){

        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();

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
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root){
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();
        TreeNode p=root;
        while(!deque.isEmpty()||null!=p){
            if(null!=p){
                deque.addFirst(p);
                p=p.left;
            }else{
                TreeNode node=deque.pollFirst();
                result.add(node.val);
                p=node.right;
            }
        }
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root){
        Deque<TreeNode> deque=new ArrayDeque<>();
        LinkedList<Integer> result=new LinkedList<>();
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

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal1(TreeNode root){
        List<Integer> result=new ArrayList<>();
        postOrderRecursiveTraversal(root,result);
        return result;
    }

    /**
     *
     * @param root
     * @param result
     */
    public void postOrderRecursiveTraversal(TreeNode root,List<Integer> result){
        if(null!=root){
            return;
        }
        result.add(root.val);
        postOrderRecursiveTraversal(root.left,result);
        postOrderRecursiveTraversal(root.right,result);
    }
}
