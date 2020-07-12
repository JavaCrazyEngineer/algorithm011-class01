import java.util.*;

/**
 * ClassName: PermuteUnique
 * Description:给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();

        int len=nums.length;

        if(len==0){
            return res;
        }

        Arrays.sort(nums);
        Deque<Integer> path=new ArrayDeque<>();

        boolean[] used=new boolean[len];

        dfs(res,nums,len,0,path,used);

        return res;
    }

    /**
     *
     * @param res
     * @param nums
     * @param len
     * @param depth
     * @param path
     * @param used
     */
    private void dfs(List<List<Integer>> res, int[] nums, int len, int depth, Deque<Integer> path, boolean[] used) {
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<len;i++){

            if(used[i]){
                continue;
            }

            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
                continue;
            }

            used[i]=true;
            path.addLast(nums[i]);

            dfs(res,nums,len,depth+1,path,used);
            path.removeLast();
            used[i]=false;
        }
    }
}
