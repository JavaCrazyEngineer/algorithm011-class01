import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大滑动窗口
 */
public class MaxSlidingWindow {

    /**
     *
     * @param a
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] a, int k) {

        if(a==null||k<0){
            return new int[0];
        }
        int n=a.length;
        int[] result=new int[n-k+1];

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        for(int i=0;i<k;i++){
            priorityQueue.add(a[i]);
        }

        result[0]=priorityQueue.peek();

        for(int i=k;i<a.length;i++){
            priorityQueue.remove(a[n-k]);
            priorityQueue.add(a[i]);

            result[n-k+1]=priorityQueue.peek();
        }

        return result;
    }
}
