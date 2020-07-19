package bfsdfs;

import week02_2.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 */
public class TreeNodeLevelOrder {

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        List<List<Integer>> resultList=new ArrayList<>();
        while(!deque.isEmpty()){
            List<Integer> node=new ArrayList<>();
            for(int i=deque.size();i>0;i--){
                TreeNode pollTreeNode=deque.poll();
                node.add(pollTreeNode.val);
                if(null!=pollTreeNode.left){
                    deque.add(pollTreeNode.left);
                }
                if(null!=pollTreeNode.right){
                    deque.add(pollTreeNode.right);
                }
            }
            resultList.add(node);
        }
        return resultList;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(5);
        System.out.println(new TreeNodeLevelOrder().levelOrder(root));
    }
}
