/**
 * ClassName: RemoveDuplicates
 * Description:删除排序数组中的重复项
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class RemoveDuplicates {

    /**
     * @param nums
     */
    public int removeDuplicates(int[] nums) {

        int removeDuplicateLength = 0;
        if (null != nums && nums.length > 0) {
            int preNum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0
                        || nums[i] != preNum) {
                    nums[removeDuplicateLength++] = nums[i];
                }
                preNum = nums[i];
            }
        }
        return removeDuplicateLength;
    }


    public static void main(String[] args) {
        //int[] nums ={0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1, 1, 2};
        int removeDuplicateLength = new RemoveDuplicates().removeDuplicates(nums);

        for (int i = 0; i < removeDuplicateLength; i++) {
            System.out.print(nums[i]);
        }
    }
}
