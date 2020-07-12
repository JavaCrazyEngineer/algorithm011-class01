package SortingAlgorithm;

/**
 * ClassName: MergeSort
 * Description:归并排序
 *
 * @author G20200343080265
 * @date 2020/07/12
 */
public class MergeSort {

    /**
     * @param arr
     */
    public void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;

            sort(arr, left, middle);

            sort(arr, middle + 1, right);

            merge(arr, left, middle, right);

        }
    }

    /**
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    private void merge(int[] arr, int left, int middle, int right) {

        int i = left, j = middle + 1, k = 0;

        int[] temp = new int[right - left + 1];

        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        int start = i, end = middle;

        if (j <= right) {
            start = j;
            end = right;
        }

        while (start <= end) {
            temp[k++] = arr[start++];
        }

        for (int r = 0; r <= (right - left); r++) {
            arr[left + r] = temp[r];
        }
    }


//    /**
//     *
//     * @param arr
//     * @param left
//     * @param middle
//     * @param right
//     */
//    private void merge(int[] arr, int left, int middle, int right) {
//
//        int leftLength=middle-left+1;
//        int rightLength=right-middle;
//
//        int[] leftArr=new int[leftLength];
//        int[] rightArr=new int[rightLength];
//
//        for(int l=0;l<leftArr.length;l++){
//            leftArr[l]=arr[left+l];
//        }
//        for(int r=0;r<rightArr.length;r++){
//            rightArr[r]=arr[middle+1+r];
//        }
//
//        int l=0,r=0;
//        int k=left;
//
//        while(l<leftLength&&r<rightLength){
//            if(leftArr[l]<rightArr[r]){
//                arr[k++]=leftArr[l++];
//            }else{
//                arr[k++]=rightArr[r++];
//            }
//        }
//
//        while(l<leftLength){
//            arr[k++]=leftArr[l++];
//        }
//
//        while (r<rightLength){
//            arr[k++]=rightArr[r++];
//        }
//    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        printArray(arr);
    }
}
