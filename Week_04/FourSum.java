import java.util.*;

/**
 * ClassName: FourSum
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/22
 */
public class FourSum {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int c;
        int d;
        for (int i = 0; i <= len - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= len - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                c = j + 1;
                d = len - 1;
                while (c < d) {
                    if (c > j + 1 && nums[c] == nums[c - 1]) {
                        c++;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[c] + nums[d] > target) {
                        d--;
                    } else if (nums[i] + nums[j] + nums[c] + nums[d] < target) {
                        c++;
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[c], nums[d])));
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }

    /**
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*int[] nums={1,2,3,4,5,6,7,8,9};
        int target=22;*/
        int[] nums={1,3,5,7,9,11,15};
        int target=32;
        System.out.println(new FourNumSum().fourSum(nums,target));
        //System.out.println(new FourSum().fourSum(nums,22));

        //[[1, 5, 11, 15], [1, 7, 9, 15], [3, 5, 9, 15], [5, 7, 9, 11]]
    }
}
