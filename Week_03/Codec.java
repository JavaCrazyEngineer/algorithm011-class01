import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * ClassName: MaxDepth
 * Description:序列化和反序列化
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class Codec {

    private static final String SPLIT = ",";
    private static final String NN = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append(NN).append(SPLIT);
        }else{
            sb.append(root.val).append(SPLIT);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLIT)));
        return buildTreeNode(nodes);
    }

    private TreeNode buildTreeNode(Deque<String> nodes) {
        String nodeVal=nodes.removeFirst();
        if(NN.equals(nodeVal)){
            return null;
        }else{
            TreeNode treeNode=new TreeNode(Integer.valueOf(nodeVal));
            treeNode.left=buildTreeNode(nodes);
            treeNode.right=buildTreeNode(nodes);
            return treeNode;
        }
    }

}
