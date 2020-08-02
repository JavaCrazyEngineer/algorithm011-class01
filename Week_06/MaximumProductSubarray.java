/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {

    /**
     * 乘积最大子数组
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] f=new int[nums.length];
        int[] g=new int[nums.length];
        f[0]=nums[0];
        g[0]=nums[0];

        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            f[i]=Math.max(Math.max(f[i-1]*nums[i],g[i-1]*nums[i]),nums[i]);
            g[i]=Math.min(Math.min(f[i-1]*nums[i],g[i-1]*nums[i]),nums[i]);
            res=Math.max(f[i],res);
        }
        return res;
    }
}
