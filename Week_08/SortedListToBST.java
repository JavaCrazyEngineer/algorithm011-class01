/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {


    /**
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {

        return buildTree(head,null);
    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * 寻找中位数节点
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private ListNode node;

    /**
     * 二叉树的中序遍历是有序的
     * @param head
     * @return
     */
    public TreeNode sortedListToBSTI(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;//获取中位数
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }


    public TreeNode sortedListToBSTII(ListNode head) {
        if(head==null) {
            return null;
        }
        return toBST(head,null);
    }

    /**
     * 快慢指针
     * @param head
     * @param tail
     * @return
     */
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) {
            return null;
        }
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
