package week01_2;

public class SwapPairs {

    /**
     *
     * @param node
     * @return
     */
    public ListNode swapPairs(ListNode node){

        //例子： 1 2 3 4
        ListNode head=new ListNode(0);
        head.next=node;

        ListNode current=head;
        //current: 0 1 2 3 4
        while(current.next!=null&&current.next.next!=null){
            //1
            ListNode first=current.next;
            //2
            ListNode second=current.next.next;

            //1->3
            first.next=second.next;

            //0->2
            current.next=second;

            //2->1
            current.next.next=first;

            //1
            current=current.next.next;

        }
        return head.next;

    }
}
