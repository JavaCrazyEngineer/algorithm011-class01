package week03_2;
import week02_2.TreeNode;
import java.util.HashMap;
import java.util.Map;
/**
 * 构建一颗二叉树（前序和中序）
 */
public class BuildTreeByPreOrderInOrder {

    /**
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> idx_map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }

        return buildTree(idx_map, preorder, 0, preorder.length-1, 0,inorder.length-1);
    }

    /**
     *
     * @param idx_map
     * @param preorder
     * @param preLeft
     * @param preRight
     * @param inLeft
     * @param inRight
     * @return
     */
    private TreeNode buildTree(Map<Integer, Integer> idx_map, int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }

        int preRootVal=preorder[preLeft];

        TreeNode root=new TreeNode(preRootVal);

        int midIndex=idx_map.get(preRootVal);
        root.left=buildTree(idx_map,preorder,preLeft+1,preLeft+(midIndex-inLeft),inLeft,midIndex);
        root.right=buildTree(idx_map,preorder,preLeft+(midIndex-inLeft)+1,preRight,midIndex+1,inRight);
        return root;
    }
}
