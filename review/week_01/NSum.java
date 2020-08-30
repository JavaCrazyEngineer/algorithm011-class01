package week_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {

    /**
     * 双指针+排序
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[]{lo, hi};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 双指针+排序+去重
     *
     * @param nums
     * @param target
     * @return
     */
    public List<int[]> twoSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;//数组索引
        List<int[]> result = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && left == nums[lo]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && right == nums[hi]) {
                    hi--;
                }
            } else {
                result.add(new int[]{lo, hi});
                while (lo < hi && left == nums[lo]) {
                    lo++;
                }
                while (lo < hi && right == nums[hi]) {
                    hi--;
                }
            }
        }
        return result;
    }

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int lo = i + 1, hi = nums.length - 1, target = 0 - nums[i];
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    int left = nums[lo], right = nums[hi];
                    if (sum < target) {
                        while (lo < hi && left == nums[lo]) {
                            lo++;
                        }
                    } else if (sum > target) {
                        while (lo < hi && right == nums[hi]) {
                            hi--;
                        }
                    } else {
                        result.add(Arrays.asList(nums[i],nums[lo], nums[hi]));
                        while (lo < hi && left == nums[lo]) {
                            lo++;
                        }
                        while (lo < hi && right == nums[hi]) {
                            hi--;
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //int[] nums = {1, 1, 1, 2, 2, 3, 3};
        //int target = 4;
        //System.out.println(new NSum().twoSumTarget(nums, target));

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new NSum().threeSum(nums));
    }


}
