package week02_2;

import java.util.HashMap;
import java.util.Map;

/**
 * two sum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer j=map.get(nums[i]-target);
            if(j!=null){
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
