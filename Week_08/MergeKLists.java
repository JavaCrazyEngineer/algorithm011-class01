import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并k个排序的列表
 */
public class MergeKLists {

    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.isEmpty()){
            return null;
        }
        return helper(lists,0,lists.size()-1);
    }

    /**
     *
     * @param lists
     * @param lo
     * @param hi
     * @return
     */
    private ListNode helper(List<ListNode> lists, int lo, int hi) {
        if(lo>hi){
            return lists.get(lo);
        }

        int mid=lo+(hi-lo)/2;
        ListNode left=helper(lists,lo,mid);
        ListNode right=helper(lists,mid+1,hi);

        return mergeTwoLists(left,right);
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergerKListsI(List<ListNode> lists){
        if(lists==null||lists.size()==0){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val){
                    return -1;
                }else if(o1.val==o2.val){
                    return 0;
                }else return 1;
            }
        });

        ListNode dummy=new ListNode(0);
        ListNode p=dummy;

        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            p.next=queue.poll();
            p=p.next;
            if(p.next!=null){
                queue.add(p.next);
            }
        }
        return dummy.next;
    }
}
