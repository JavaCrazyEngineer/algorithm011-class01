/**
 * ClassName: ArrayClimbStairs
 * Description:爬楼梯
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class ArrayClimbStairs {

    public int climbStairs(int n) {
        if(n==0||n==1|n==2){
            return n;
        }
        int[] mem=new int[n];
        mem[0]=1;
        mem[1]=2;
        for(int i=2;i<n;i++){
            mem[i]=mem[i-1]+mem[i-2];
        }
        return mem[n-1];
    }
}
