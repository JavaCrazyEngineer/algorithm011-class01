package week01_2;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode prev=null;
        while(head!=null){
            ListNode current=head.next;
            head.next=prev;
            prev=head;
            head=current;
        }
        return prev;
    }
}
