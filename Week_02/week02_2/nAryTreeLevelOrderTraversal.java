package week02_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n叉树的层序遍历
 */
public class nAryTreeLevelOrderTraversal {

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> listNode = new ArrayList<>();
            for (int l = deque.size(); l > 0; l--) {
                Node node = deque.poll();
                listNode.add(node.val);
                if (null != node.children) {
                    for (Node childNode : node.children) {
                        deque.addLast(childNode);
                    }
                }
            }
            result.add(listNode);
        }
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root){
        List<List<Integer>> result = new ArrayList<>();

        levelOrder1(root,result,0);
        return result;
    }

    /**
     *
     * @param root
     * @param result
     * @param level
     */
    private void levelOrder1(Node root, List<List<Integer>> result, int level) {
        if(result.size()<=level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        if(null==root.children){
            return;
        }
        for(Node node:root.children){
            levelOrder1(node,result,level+1);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        List<Node> childNodes = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            Node node = new Node(i);
            List<Node> subChilds = new ArrayList<>();
            for (int j = 2 * i; j< 10; j++) {
                Node subChild = new Node(j);
                subChilds.add(subChild);
            }
            node.children = subChilds;
            childNodes.add(node);
        }
        root.children = childNodes;
        System.out.println(new nAryTreeLevelOrderTraversal().levelOrder(root));
        System.out.println(new nAryTreeLevelOrderTraversal().levelOrder1(root));
    }
}
