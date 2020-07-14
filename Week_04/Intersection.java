import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1,int[] nums2){

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(null!=map.get(nums2[i])
                    &&map.get(nums2[i])>0){
                result.add(nums2[i]);
                map.replace(nums2[i],map.get(nums2[i])-1);
            }
        }

        int[] ret=new int[result.size()];

        for(int i=0;i<result.size();i++){
            ret[i]=result.get(i);
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] nums1={1,2,3,4};
        int[] nums2={2,2,2,5,4};
        int[] ret=new Intersection().intersect(nums1,nums2);
        for(int i=0;i<ret.length;i++){
            System.out.print(ret[i]+"\t");
        }
    }
}
