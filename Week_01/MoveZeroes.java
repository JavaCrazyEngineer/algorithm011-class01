/**
 * ClassName: MoveZeroes
 * Description:移动零
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class MoveZeroes {

    /**
     * 方法1：需要二次遍历
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 方法二：一次遍历，交换元素
     * @param nums
     */
    public void moveZeroes1(int[] nums) {

        int j = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp=nums[i];
                nums[i]=nums[j];
                nums[j++]=temp;
            }
        }

    }


    /**
     * 0 0 1 2 3
     *
     * j、i初始化指向第一个元素
     * 遍历，nums[i]!=0，交换a[i]、a[j]
     *
     * 1<->0交换，j为1
     * 2<->0交换，j为2
     * 3<->0交换，j为3
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums={0,1,0,3,12};
        //new MoveZeroes().moveZeroes(nums);

        new MoveZeroes().moveZeroes1(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
