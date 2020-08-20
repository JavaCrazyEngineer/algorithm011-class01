/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] arr) {
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

        int middle = left + ((right - left) >> 1);

        sort(arr, left, middle);
        sort(arr, middle + 1, right);

        merge(arr, left, middle, right);
    }

    /**
     * 合并排序，左右子数组
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    private void merge(int[] arr, int left, int middle, int right) {

        int i = left, j = middle + 1, t = 0;
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        int start = i, end = middle;
        if (j <= right) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[i++] = arr[start++];
        }
        for (int r = 0; r < temp.length; r++) {
            arr[left + r] = temp[r];
        }
    }
}
