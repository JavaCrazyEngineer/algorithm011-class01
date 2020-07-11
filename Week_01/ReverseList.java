/**
 * ClassName: ReverseList
 * Description:旋转链表
 *
 * @author G20200343080265
 * @date 2020/06/27
 */
public class ReverseList {


    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode prevNode=null;
        while(head!=null){
            ListNode currentNode=head.next;
            head.next=prevNode;
            prevNode=head;
            head=currentNode;
        }
        return prevNode;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode head=new ListNode();
        ListNode reversePrev=head;
        for(int i=0;i<5;i++){
            ListNode newListNode=new ListNode(i);
            head.next=newListNode;
            head=head.next;
        }
        ListNode reverseAfter=new ReverseList().reverseList(reversePrev.next);

        while(null!=reverseAfter){
            System.out.print(reverseAfter.val);
            reverseAfter=reverseAfter.next;
        }
    }
}
