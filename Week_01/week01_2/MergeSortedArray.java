package week01_2;

public class MergeSortedArray {

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] cpNums1=new int[nums1.length];
        System.arraycopy(nums1,0,cpNums1,0,nums1.length);

        int num1Index=0,nums2Index=0,cpNum1Index=0;
        while(cpNum1Index<m&&nums2Index<n){
            nums1[num1Index++] =cpNums1[cpNum1Index]<=nums2[nums2Index]?cpNums1[cpNum1Index++]:nums2[nums2Index++];
        }

        while(cpNum1Index<m){
            nums1[num1Index++] =cpNums1[cpNum1Index++];
        }

        while(nums2Index<n){
            nums1[num1Index++] =nums2[nums2Index++];
        }
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] cp_nums1=new int[nums1.length];

        System.arraycopy(nums1,0,cp_nums1,0,nums1.length);

        int nums1Index = 0,nums2Index=0,cp_nums1Index=0;

        while(cp_nums1Index<m&&nums2Index<n){
            nums1[nums1Index++]=(cp_nums1[cp_nums1Index]<=nums2[nums2Index])?cp_nums1[cp_nums1Index++]:nums2[nums2Index++];
        }
        if(cp_nums1Index<m){
            System.arraycopy(cp_nums1,cp_nums1Index,nums1,nums1Index,m-cp_nums1Index);
        }
        if(nums2Index<n){
            System.arraycopy(nums2,nums2Index,nums1,nums1Index,n-nums2Index);
        }
    }
}
