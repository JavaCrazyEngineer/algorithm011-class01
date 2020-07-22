package week03_2;

import java.util.*;

/**
 * 给定一个没有重复的数字，给出所有的全排列
 */
public class PermuteUnique {

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        if (length <= 0) {
            return result;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[length];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(result, nums, 0, length, used, path);
        return result;
    }

    /**
     * @param result
     * @param nums
     * @param depth
     * @param length
     * @param used
     * @param path
     */
    private void dfs(List<List<Integer>> result, int[] nums, int depth, int length, boolean[] used, Deque<Integer> path) {

        if (depth == length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < length; i++) {

            if (used[i] == true) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i] == false) {
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(result, nums, depth + 1, length, used, path);
            path.removeLast();
            used[i]=false;

        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(new PermuteUnique().permute(nums));
    }
}
