import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: ThreeSum
 * Description:三数之和
 *
 * @author G20200343080265
 * @date 2020/06/27
 */
public class ThreeSum {

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Stream.of(nums[i], nums[j], nums[k])
                                .collect(Collectors.toList());
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = new ThreeSum().threeSum1(nums);
        //[[-1, -1, 2], [-1, 0, 1]]

        System.out.println(result);
    }


}
