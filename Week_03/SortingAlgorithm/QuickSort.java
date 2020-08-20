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
     *
     * pivot=5,i=0
     *1、10<5
     *2、7<5
     *3、8<5
     *4、9<5
     *5、1<5, 交换 arr[0]～arr[4]，交换 10和1，结果 1 7 8 9 10 5，i++为1
     *6、结束
     *
     * i等于1，arr[right->5]=5,arr[i->1]=7,交换 arr[1]～arr[5], 结果为 1 5 8 9 10 7，pivot值为5 下标为1 并返回
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
