import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: nAryTreePreorderTraversal
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class nAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (null != root) {
            List<Integer> preOrders = new ArrayList<>(6);
            preOrderRecursion(root, preOrders);
            return preOrders;
        }
        return Collections.emptyList();
    }

    /**
     * 层次递归
     *
     * @param root
     * @param preOrders
     */
    private void preOrderRecursion(Node root, List<Integer> preOrders) {
        preOrders.add(root.val);
        if (null != root.children) {
            for (Node child : root.children) {
                preOrderRecursion(child, preOrders);
            }
        }
    }
}
