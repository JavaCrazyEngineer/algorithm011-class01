/**
 * ClassName: MergeTwoLists
 * Description:合并两个有序链表
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class MergeTwoLists {

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead=new ListNode();

        ListNode prev=preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next=l1;
                l1=l1.next;
            } else {
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=(l1==null)?l2:l1;
        return preHead.next;
    }



    public static void main(String[] args) {
        ListNode l1Next=new ListNode(3);
        ListNode l1=new ListNode(1,l1Next);

        ListNode l2Next1=new ListNode(6);
        ListNode l2Next=new ListNode(5,l2Next1);
        ListNode l2=new ListNode(2,l2Next);

        ListNode resultNode=new MergeTwoLists().mergeTwoLists(l1,l2);

        while(null!=resultNode){
            System.out.print(resultNode.val);
            resultNode=resultNode.next;
        }
    }
}
