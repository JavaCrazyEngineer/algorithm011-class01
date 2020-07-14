package week01_2;

public class ListCycle {


    public boolean hasCycle(ListNode head) {

        if(null==head||head.next==null){
            return false;
        }

        ListNode slow=head;
        ListNode fast=head.next;

        while(slow!=fast){
            if(null==fast||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return true;
    }
}
