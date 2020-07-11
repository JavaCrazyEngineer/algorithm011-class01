/**
 * ClassName: SwapPairs
 * Description:两两交换链表中的元素
 *
 * @author G20200343080265
 * @date 2020/06/27
 */
public class SwapPairs {

    /**
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        //1->2->3->4->5
        while (current.next != null && current.next.next != null) {

            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
