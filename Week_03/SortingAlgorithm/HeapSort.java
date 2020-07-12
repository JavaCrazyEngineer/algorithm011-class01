package SortingAlgorithm;
/**
 * ClassName: HeapSort
 * Description:堆排序
 *
 * @author G20200343080265
 * @date 2020/07/12
 */
public class HeapSort {

    /**
     *
     * @param arr
     */
    public void sort(int arr[]){


        int n=arr.length;
        buildHeap(arr,n);

    }


    /**
     *
     * @param arr
     * @param n
     */
    private void buildHeap(int[] arr,int n) {

        for(int i=(n>>1)-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){

            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,i,0);

        }
    }

    /**
     *
     * @param arr
     * @param n
     * @param i
     */
    private void heapify(int[] arr, int n, int i) {
        int largest=i;
        int leftIndex=(i<<1)+1;
        int rightIndex=(i<<1)+2;

        if(leftIndex<n&&arr[leftIndex]>arr[largest]){
            largest=leftIndex;
        }

        if(rightIndex<n&&arr[rightIndex]>arr[largest]){
            largest=rightIndex;
        }

        if(largest!=i){

            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            heapify(arr,n,largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
