package SortingAlgorithm;

/**
 * ClassName: QuickSort
 * Description:归并排序
 *
 * @author G20200343080265
 * @date 2020/07/12
 */
public class QuickSort {

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

        if (left >= right) {
            return;
        }

        int pi = partition(arr, left, right);

        sort(arr, left, pi - 1);

        sort(arr, pi + 1, right);
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @return 10, 7, 8, 9, 1, 5
     * pivot=5
     * <p>
     * 10 7 8 9 1 =>pivot:5
     * 1 5 7 8 9 10
     * i=0
     * <p>
     * j
     */
    private int partition(int[] arr, int left, int right) {

        int pivot = arr[right];

        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i = i + 1;
            }
        }
        int temp = arr[right];
        arr[right] = arr[i];
        arr[i] = temp;
        return i;
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
