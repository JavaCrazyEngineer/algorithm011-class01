package week01_2;

public class ReverseKGroup {

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        while(curr!=null&&count!=k){
            ++count;
            curr=curr.next;
        }
        if(count==k){

            curr=reverseKGroup(curr,k);

            while(count-->0){

                ListNode temp=head.next;
                head.next=curr;
                curr=head;
                head=temp;
            }

            head=curr;
        }
        return head;
    }
}
