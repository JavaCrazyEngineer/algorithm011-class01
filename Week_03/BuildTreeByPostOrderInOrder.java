import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BuildTreeByPostOrderInOrder
 * Description:构建一颗二叉树
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class BuildTreeByPostOrderInOrder {

    public TreeNode buildTree(int[] postOrder, int[] inOrder) {

        int poLen=postOrder.length;
        int inLen=inOrder.length;

        if(poLen!=inLen){
            throw new IllegalArgumentException("illegal argument");
        }

        Map<Integer,Integer> inOrderMap=new HashMap<>(inLen);

        for(int i=0;i<inLen;i++){
            inOrderMap.put(inOrder[i],i);
        }

        return buildTreePostIn(inOrder,0,inLen-1,postOrder,0,postOrder.length-1,inOrderMap);

    }

    /**
     *
     * @param inOrder
     * @param is
     * @param ie
     * @param postOrder
     * @param ps
     * @param pe
     * @param hm
     * @return
     */
    private TreeNode buildTreePostIn(int[] inOrder, int is, int ie, int[] postOrder, int ps, int pe,
                                     Map<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postOrder[pe]);
        int ri = hm.get(postOrder[pe]);
        root.left = buildTreePostIn(inOrder, is, ri-1, postOrder, ps, ps+ri-is-1, hm);
        root.right = buildTreePostIn(inOrder,ri+1, ie, postOrder, ps+ri-is, pe-1, hm);
        return root;
    }
}
