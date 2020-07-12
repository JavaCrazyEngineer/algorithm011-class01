import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MajorityElement
 * Description:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class MajorityElement {

    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int L = nums.length;
        Map<Integer,Integer> myMap=new HashMap<>();

        for(int num:nums){
            if(!myMap.containsKey(num)){
                myMap.put(num,1);
            }else{
                myMap.put(num,myMap.get(num)+1);
                if(myMap.get(num)>nums.length>>1){
                   return num;
                }
            }
        }
        return nums[L-1];
    }
}
