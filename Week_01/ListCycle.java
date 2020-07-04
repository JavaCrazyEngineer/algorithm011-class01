/**
 * ClassName: ListCycle
 * Description:链表是否有环
 *
 * @author G20200343080265
 * @date 2020/06/27
 */
public class ListCycle {

    /**
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){

        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }

}
