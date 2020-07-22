package week03_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个没有重复的数字，给出所有的全排列
 */
public class Permute {

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

        boolean[] used = new boolean[length];

        Deque<Integer> path = new ArrayDeque<>();
        dfs(result, nums, 0, length, used,path);
        return result;
    }

    /**
     * @param result
     * @param nums
     * @param level
     * @param length
     * @param used
     * @param path
     */
    private void dfs(List<List<Integer>> result, int[] nums, int level, int length, boolean[] used, Deque<Integer> path) {
      if(level==length){
          result.add(new ArrayList<>(path));
      }
      for(int i=0;i<nums.length;i++){
          if(used[i]){
              continue;
          }
          path.addLast(nums[i]);
          used[i]=true;
          dfs(result,nums,level+1,length,used,path);
          path.removeLast();
          used[i]=false;
      }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Permute().permute(nums));
    }
}
