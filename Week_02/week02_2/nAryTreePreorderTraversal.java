package week02_2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * n叉树的前序遍历
 */
public class nAryTreePreorderTraversal {

    /**
     * 队列
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (null != root) {
            deque.addLast(root);
            while (!deque.isEmpty()) {
                Node node = deque.pollLast();
                result.add(node.val);
                if (null != node.children) {
                    for(int i=node.children.size()-1;i>=0;i--){
                        deque.addLast(node.children.get(i));
                    }
                }
            }
        }
        return result;
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {

        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    /**
     * @param root
     * @param result
     */
    private void preorder(Node root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        if (null != root.children) {
            for (Node child : root.children) {
                preorder(child, result);
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> childNodes = new ArrayList<>();
        for (int i = 3; i < 5; i++) {
            Node node = new Node(i);
            List<Node> subChilds = new ArrayList<>();
            for (int j = 2 * i; j < 10; j++) {
                Node subChild = new Node(j);
                subChilds.add(subChild);
            }
            node.children = subChilds;
            childNodes.add(node);
        }
        root.children = childNodes;
        System.out.println(new nAryTreePreorderTraversal().preorder(root));
        System.out.println(new nAryTreePreorderTraversal().preorder1(root));
    }
}
