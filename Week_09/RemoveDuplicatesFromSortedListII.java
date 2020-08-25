/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        return backtrack(head,null);
    }

    /**
     *
     * @param head
     * @param prev
     * @return
     */
    private ListNode backtrack(ListNode head, ListNode prev) {
        if(head==null){
            return null;
        }
        if(prev!=null&&head.val==prev.val||head.next!=null&&head.val==head.next.val){
            return backtrack(head.next,head);//存在重复元素情况
        }else{
            head.next=backtrack(head.next,head);
            return head;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next!=null&&head.val==head.next.val){
            while(head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next=deleteDuplicates(head.next);
        }
        return head;
    }
}
