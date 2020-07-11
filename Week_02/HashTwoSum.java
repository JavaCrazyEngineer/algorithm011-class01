import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoSum
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class HashTwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> twoSumMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = twoSumMap.get(target - nums[i]);
            if (j != null) {
                return new int[]{j, i};
            }
            twoSumMap.put(nums[i], i);
        }
        return null;
    }
}
