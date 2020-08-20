/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int arr[]){
        sort(arr,0,arr.length-1);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int pi=partition(arr,left,right);
        sort(arr,left,pi);
        sort(arr,pi+1,right);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int pivot=right;
        int i=left;

        for(int j=left;j<right;j++){
            if(arr[j]<pivot){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
        int temp=arr[right];
        arr[right]=arr[i];
        arr[i]=temp;
        return i;
    }
}
