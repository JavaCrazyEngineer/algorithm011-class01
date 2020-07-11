import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SubSets
 * Description:给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans=new ArrayList<>();
        if(nums==null){
            return ans;
        }
        dfs(ans,nums,new ArrayList<Integer>(),0);

        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {

        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans,nums,list,index+1);
        list.add(nums[index]);
        dfs(ans,nums,list,index+1);

        list.remove(list.size()-1);

    }

}
