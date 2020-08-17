/**
 *
 */
public class CountBits {

    public int[] countBits(int num){
        int[] arr=new int[num+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=popCount(i);
        }
        return arr;
    }

    private int popCount(int i) {
        int count=0;
        while(i!=0){
            i=i&(i-1);//去掉一位数字1
            count++;
        }
        return count;
    }
}
