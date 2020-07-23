import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * four sum
 */
public class FourNumSum {

    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i <= len - 4; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j <= len - 3; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int c = j + 1;
                int d = len - 1;
                while (c < d) {
                    if (c > j + 1 && nums[c - 1] == nums[c]) {
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[c]+nums[d]<target){
                        c++;
                    }else if(nums[i]+nums[j]+nums[c]+nums[d]>target){
                        d--;
                    }else{
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[c],nums[d])));
                        /*while (c < d && nums[c + 1] == nums[c])      //确保nums[c] 改变了
                        {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d])      //确保nums[d] 改变了
                        {
                            d--;
                        }*/
                        c++;
                        d--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4)
            return lists;
        int a, b, c, d;
        for (a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        /*while (c < d && nums[c + 1] == nums[c])      //确保nums[c] 改变了
                        {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d])      //确保nums[d] 改变了
                        {
                            d--;
                        }*/
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,7,9,11,15};
        int target=32;
        System.out.println(new FourNumSum().fourSum1(nums,target));
        System.out.println(new FourNumSum().fourSum(nums,target));
    }
}
