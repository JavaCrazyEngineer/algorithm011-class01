package week03_2;

import week02_2.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 构建二叉搜索树（前序遍历）
 */
public class BuildBSTFromPreorder {

    /**
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {

        if (null == preorder || preorder.length == 0) {
            return null;
        }
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);//升序
        Map<Integer, Integer> idx_map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, idx_map);
    }

    /**
     * @param preorder
     * @param preLeft
     * @param preRight
     * @param inLeft
     * @param inRight
     * @param idx_map
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> idx_map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int preRootValue = preorder[preLeft];//得到前序  根节点

        int midIndex = idx_map.get(preRootValue);//得到 中序 根节点所在的位置

        TreeNode root = new TreeNode(preRootValue);

        //左子树
        root.left = buildTree(preorder, preLeft + 1, preLeft + (midIndex - inLeft), inLeft, midIndex - 1, idx_map);
        //右子树
        root.right = buildTree(preorder, preLeft + (midIndex - inLeft) + 1, preRight, midIndex + 1, inRight, idx_map);
        return root;
    }


    /**
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder1(int[] preorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            addTreeNode(root, preorder[i]);
        }
        return root;
    }

    /**
     * 新增节点
     * @param root
     * @param k
     */
    private void addTreeNode(TreeNode root, int k) {
        TreeNode node = new TreeNode(k);
        TreeNode p = root;
        while (true) {
            if (p.val > k) {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
    }


    public static void main(String[] args) {

        //[8,5,1,7,10,12]
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        System.out.println(new BuildBSTFromPreorder().bstFromPreorder(preOrder));
        System.out.println(new BuildBSTFromPreorder().bstFromPreorder1(preOrder));
    }
}
