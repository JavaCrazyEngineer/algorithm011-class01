/**
 * 链表节点之和
 */
public class ListNodeTwoSum {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }

        ListNode result=null;
        ListNode current=new ListNode(0);
        int carry=0;

        while(null!=l1||l2!=null){
            int sum=carry;
            sum=l1!=null?sum+l1.val:sum;
            sum=l2!=null?sum+l2.val:sum;

            current.next=new ListNode(sum%10);
            if(result==null){
                result=current.next;
            }
            carry=sum/10;
            current=current.next;
            l1=l1!=null?l1.next: null;
            l2=l2!=null?l2.next:null;
        }

        if(carry>0){
            current.next=new ListNode(carry);
        }
        return result;

    }
}
