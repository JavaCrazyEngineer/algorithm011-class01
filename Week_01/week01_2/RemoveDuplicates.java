package week01_2;

public class RemoveDuplicates {

    /**
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int d=0;
        nums[d++]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[d++]=nums[i];
            }
        }
        return d;
    }
}