package week01_2;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] rotates=new int[nums.length];
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            rotates[(i+k)%len]=nums[i];
        }
        System.arraycopy(rotates,0,nums,0,len);
    }


    public static void main(String[] args) {

        int[] nums={1,3,5,7,9,10,2,6};
        int k=3;
        new RotateArray().rotate(nums,k);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
