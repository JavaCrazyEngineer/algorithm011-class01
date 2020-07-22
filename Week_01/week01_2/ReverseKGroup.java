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


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(3);
        ListNode three=new ListNode(4);
        second.next=three;
        first.next=second;
        head.next=first;
        new ReverseKGroup().reverseKGroup(head,2);
    }
}
