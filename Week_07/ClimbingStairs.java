/**
 * ClassName: ClimbingStairs
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/08/09
 */
public class ClimbingStairs {

    /**
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int[] dp=new int[n+1];

        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i];
        }

        return dp[n];
    }

    /**
     *
     * @param n
     * @return
     */
    public int climbStairsI(int n) {

        int first=1;
        int second=1;

        for(int i=2;i<=n;i++){
            int temp=first+second;
            first=second;
            second=temp;
        }
        return second;
    }

    /**
     *
     * @param n
     * @return
     */
    public int climbStairsII(int n) {

        int[] memo=new int[n+1];

        return recursionFib(memo,n);
    }

    /**
     *
     * @param memo
     * @param n
     * @return
     */
    private int recursionFib(int[] memo, int n) {
        if(n<=1){
            return n;
        }
        if(memo[n]==0){
            memo[n]=recursionFib(memo,n-1)+recursionFib(memo,n-2);
        }
        return memo[n];
    }
}
