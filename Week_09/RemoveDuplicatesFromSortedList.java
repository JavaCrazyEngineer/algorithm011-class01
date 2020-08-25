/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;//单独定义一个变量指向链表头节点
        while(current!=null&&current.next!=null){
            if(current.val==current.next.val){
                current=current.next.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesI(ListNode head) {

        if(head==null){
            return null;
        }
        ListNode prev=head;
        while(prev.next!=null){
            ListNode current=prev.next;
            if(current.val==prev.val){
                prev.next=current.next;
            }else{
                prev=current;
            }
        }
        return head;
    }
}
