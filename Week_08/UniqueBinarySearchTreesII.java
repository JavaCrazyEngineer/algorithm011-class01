import java.util.ArrayList;
import java.util.List;
/**
 * 95. ��ͬ�Ķ��������� II
 * ����һ������ n������������ 1 ... n Ϊ�ڵ�����ɵ� ���������� ��
 * <p>
 * <p>
 * <p>
 * ʾ����
 * <p>
 * ���룺3
 * �����
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * ���ͣ�
 * ���ϵ������Ӧ���� 5 �ֲ�ͬ�ṹ�Ķ�����������
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= n <= 8
 */
public class UniqueBinarySearchTreesII {

    /**
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {

        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }
        return list;
    }
}
