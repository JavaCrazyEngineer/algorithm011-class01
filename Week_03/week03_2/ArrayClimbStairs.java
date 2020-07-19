package week03_2;
/**
 *爬楼梯
 */
public class ArrayClimbStairs {

    /**
     *
     * @param n
     * @return
     */
    public int climbStairs(int n){

        if(n<=2){
            return n;
        }

        int[] steps=new int[n];
        steps[0]=1;
        steps[1]=2;
        for(int i=2;i<n;i++){
            steps[i]=steps[i-2]+steps[i-1];
        }

        return steps[n-1];

    }
}
