/**
 * 爬楼梯问题
 */
public class Fib {

    /**
     *
     * @param n
     * @return
     */
    int fib(int n){
        int[] dp=new int[n+1];//n+1代表第n级台阶
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];//dp递推公式
        }
        return dp[n];
    }
}
