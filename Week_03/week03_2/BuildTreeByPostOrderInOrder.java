package week03_2;
import week02_2.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 构建一颗二叉树（后序和中序）
 */
public class BuildTreeByPostOrderInOrder {

    /**
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *
     * 3
     * 后序根节点:postRight
     * 中序节点：midIndex
     * 中序左子树：inLeft ,midIndex-1 中序右子树：midIndex+1,inRight
     * 后序左子树：postLeft,postLeft+(minIndex-inLeft)-1 后序右子树：postLeft+(minIndex-inLeft),potRight
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] postorder, int[] inorder) {

        if(null==postorder||null==inorder){
            return null;
        }

        Map<Integer,Integer> idx_map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            idx_map.put(inorder[i],i);
        }
        return buildTree(postorder,0,inorder.length-1,0,postorder.length-1,idx_map);
    }

    /**
     *
     * @param postorder
     * @param inLeft
     * @param inRight
     * @param postLeft
     * @param postRight
     * @param idx_map
     * @return
     */
    private TreeNode buildTree(int[] postorder, int inLeft, int inRight, int postLeft, int postRight, Map<Integer, Integer> idx_map) {
        if(inLeft>inRight||postLeft>postRight){
            return null;
        }

        int postRootVal=postorder[postRight];
        int midIndex=idx_map.get(postRootVal);
        TreeNode root=new TreeNode(postRootVal);
        root.left=buildTree(postorder,inLeft,midIndex-1,postLeft,postLeft+(midIndex-inLeft)-1,idx_map);
        root.right=buildTree(postorder,midIndex+1,postRight,postLeft+(midIndex-inLeft),postRight-1,idx_map);
        return root;
    }
}
