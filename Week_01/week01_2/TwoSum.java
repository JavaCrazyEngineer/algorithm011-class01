package week01_2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> numMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer j=numMap.get(target-nums[i]);
            if(j!=null){
                return new int[]{i,j};
            }
            numMap.put(nums[i],i);
        }
        return null;
     }
    }
