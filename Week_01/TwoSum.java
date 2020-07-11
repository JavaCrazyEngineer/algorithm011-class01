import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoSum
 * Description:两数之和
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class TwoSum {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = new HashTwoSum().twoSum(nums, target);

        System.out.print(result[0]+":"+result[1]);
    }
}
