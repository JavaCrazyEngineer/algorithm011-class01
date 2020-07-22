package week03_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class SubSets {

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    /**
     * @param ans
     * @param nums
     * @param list
     * @param index
     */
    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        dfs(ans, nums, list, index + 1);
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new SubSets().subsets(nums));
    }
}
