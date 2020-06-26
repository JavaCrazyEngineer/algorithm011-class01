/**
 * ClassName: MergeSortedArray
 * Description:合并两个有序数组
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class MergeSortedArray {

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int nums1CopyIndex = 0;
        int nums2Index = 0;
        int nums1Index = 0;
        while (nums1CopyIndex < m
                && nums2Index < n) {
            nums1[nums1Index++] = nums1Copy[nums1CopyIndex] < nums2[nums2Index] ? nums1Copy[nums1CopyIndex++] : nums2[nums2Index++];
        }

        if (nums1CopyIndex < m) {
            System.arraycopy(nums1Copy, nums1CopyIndex, nums1, nums1CopyIndex + nums2Index, m + n - nums1CopyIndex - nums2Index);
        }

        if (nums2Index < n) {
            System.arraycopy(nums2, nums2Index, nums1, nums1CopyIndex + nums2Index, m + n - nums1CopyIndex - nums2Index);
        }
    }


    /**
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }
}
