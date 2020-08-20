import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence(最长上升子序列)
 * Medium
 *
 * 5108
 *
 * 115
 *
 * Add to List
 *
 * Share
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */
public class LengthOfLIS {

    /**
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if(nums.length==0){
           return 0;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int lengthOfLISI(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if(i == len) {
                len++;
            }
        }

        return len;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args){

        int[] nums= new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        new LengthOfLIS().lengthOfLISI(nums);
    }
}
