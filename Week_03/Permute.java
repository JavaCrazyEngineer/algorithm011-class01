import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: Permute
 * Description:给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();

        int length=nums.length;
        if(length==0){
            return res;
        }

        Deque<Integer> path=new ArrayDeque<>();

        boolean[] used=new boolean[length];
        dfs(nums,length,0,path,used,res);
        return res;
    }

    /**
     *
     * @param nums
     * @param length
     * @param depth
     * @param path
     * @param used
     * @param res
     */
    private void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {

        if(depth==length){
            res.add(new ArrayList<>(path));
        }

        for(int i=0;i<length;i++){
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,length,depth+1,path,used,res);
            path.removeLast();
            used[i]=false;
        }
    }

}
