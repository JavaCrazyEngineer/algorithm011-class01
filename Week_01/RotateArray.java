/**
 * ClassName: RotateArray
 * Description:旋转数组
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class RotateArray {

    /**
     * 方法一：暴利求解
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (null != nums && nums.length > 0 && k > 0) {
            for (int r = 0; r < k; r++) {
                int prevNum = nums[nums.length - 1];
                int currentNum;
                for (int i = 0; i < nums.length; i++) {
                    currentNum = nums[i];
                    nums[i] = prevNum;
                    prevNum = currentNum;
                }
            }
        }
    }

    /**
     * 方法二：额外空间，(i+k)%nums.length
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {

        if (null != nums && nums.length > 0
                && k > 0) {
            int[] rotates = new int[nums.length];
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                rotates[(i + k) % nums.length] = nums[i];
            }
            System.arraycopy(rotates, 0, nums, 0, length);
        }
    }

    /**
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //new RotateArray().rotate(nums, k);
        //new RotateArray().rotate1(nums, k);
        new RotateArray().rotate3(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
