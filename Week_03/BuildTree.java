import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BuildTree
 * Description:构建一颗二叉树
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLen=preorder.length;
        int inLen=inorder.length;

        if(preLen!=inLen){
            throw new IllegalArgumentException("illegal argument");
        }

        Map<Integer,Integer> inOrderMap=new HashMap<>(inorder.length);

        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        return buildTree(preorder,0,preLen-1,inOrderMap,0,inLen-1);

    }

    /**
     *
     * @param preOrder
     * @param preLeft
     * @param preLeft
     * @param inOrderMap
     * @param inLeft
     * @param inRight
     * @return
     */
    private TreeNode buildTree(int[] preOrder, int preLeft ,int preRight, Map<Integer, Integer> inOrderMap, int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight){
            return  null;
        }
        int rootVal=preOrder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int pIndex=inOrderMap.get(rootVal);

        root.left=buildTree(preOrder,preLeft+1,pIndex-inLeft+preLeft,inOrderMap,inLeft,pIndex-1);
        root.right=buildTree(preOrder,pIndex-inLeft+preLeft+1,preRight,inOrderMap,pIndex+1,inRight);
        return root;
    }
}
