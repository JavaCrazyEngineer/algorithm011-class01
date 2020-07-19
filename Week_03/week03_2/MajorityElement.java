package week03_2;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MajorityElement
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/19
 */
public class MajorityElement {

    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        int l=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
                if(map.get(num)>nums.length>>1){
                    return num;
                }
            }
        }
        return nums[l-1];
    }
}
