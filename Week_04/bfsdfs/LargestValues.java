package bfsdfs;

import week02_2.TreeNode;

import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class LargestValues {

    /**
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> largests = new ArrayList<>(3);
        if(null!=root){
            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode p = root;
            deque.offer(p);
            while (!deque.isEmpty()) {
                int size = deque.size();
                Integer maxVal=null;
                for (int i = 0; i < size; i++) {
                    TreeNode node= deque.poll();
                    maxVal=(maxVal==null)?node.val:Math.max(node.val,maxVal);
                    if(null!=node.left){
                        deque.offer(node.left);
                    }
                    if(null!=node.right){
                        deque.offer(node.right);
                    }
                }
                largests.add(maxVal);
            }
        }
        return largests;
    }
}
