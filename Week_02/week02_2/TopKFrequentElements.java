package week02_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TOPK
 */
public class TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> frequentMap=new HashMap<>();
        List<Integer>[] frequents=new List[nums.length+1];
        for(int num:nums){
            frequentMap.put(num,frequentMap.getOrDefault(num,0)+1);
        }

        for(Integer num:frequentMap.keySet()){
            Integer frequent=frequentMap.get(num);
            if(null==frequents[frequent]){
                frequents[frequent]=new ArrayList<>();
            }
            frequents[frequent].add(num);
        }

        int[] result=new int[k];
        int r=0;
        for(int pos=frequents.length-1;pos>=0&&r<k;pos--){
            if(frequents[pos]!=null){
                List<Integer> kFrequent= frequents[pos];
                for(int i=0;i<kFrequent.size()&&r<k;i++){
                    result[r++]=kFrequent.get(i);
                }
            }
        }
        return result;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums={1,2};
        int k=2;
        printArray(new TopKFrequentElements().topKFrequent(nums,k));
    }
}
