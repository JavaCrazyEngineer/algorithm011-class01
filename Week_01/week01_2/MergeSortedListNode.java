package week01_2;

public class MergeSortedListNode {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode sortedListNode=new ListNode();

        ListNode resultNode=sortedListNode;

        while (null!=l1&&null!=l2){
            if(l1.val<l2.val) {
                sortedListNode.next=l1;
                l1=l1.next;
            }else{
                sortedListNode.next=l2;
                l2=l2.next;
            }
            sortedListNode=sortedListNode.next;
        }
        sortedListNode.next=(null!=l1?l1:l2);

        return resultNode.next;
      }
}
