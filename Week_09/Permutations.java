import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    List<List<Integer>> res=new LinkedList<>();

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    /**
     *
     * @param nums
     * @param track
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //排除不合法的选择
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一轮决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }
}
