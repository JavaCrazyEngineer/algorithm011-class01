import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: nAryTreeLevelOrderTraversal
 * Description:二叉树层序遍历
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class nAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null != root) {
            levelOrder(root, 0, result);
            return result;
        }
        return result;
    }

    /**
     * @param root
     * @param level
     * @param result
     */
    private void levelOrder(Node root, int level, List<List<Integer>> result) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        for (Node node : root.children) {
            levelOrder(node, level + 1, result);
        }
    }


    /*public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;
    }*/
}
